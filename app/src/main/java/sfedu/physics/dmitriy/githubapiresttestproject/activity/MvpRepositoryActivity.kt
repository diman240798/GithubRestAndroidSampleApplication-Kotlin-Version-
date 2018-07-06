package sfedu.physics.dmitriy.githubapiresttestproject.activity


import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import sfedu.physics.dmitriy.githubapiresttestproject.R
import sfedu.physics.dmitriy.githubapiresttestproject.adapter.RepositoryAdapter
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.repos_model.Repository
import sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries.RepositoriesPresenter
import sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries.RepositoriesView
import sfedu.physics.dmitriy.githubapiresttestproject.realmDAO.RepositoryDao
import sfedu.physics.dmitriy.githubapiresttestproject.utils.NetWorkUtils

class MvpRepositoryActivity : MvpAppCompatActivity(), RepositoriesView {

    lateinit var recyclerView: RecyclerView
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var progressDialog: ProgressDialog
    var userName: String? = null
    lateinit  var repositoryDao: RepositoryDao

    @InjectPresenter
    lateinit var repositoriesPresenter: RepositoriesPresenter

    var repositoryAdapter: RepositoryAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        repositoryDao = RepositoryDao()

        // Check If intent came with userLogin or Quit if not
        userName = intent.action
        if (userName == null) {
            Toast.makeText(this, "UserLogin is not loaded", Toast.LENGTH_SHORT).show()
            finish()
        }

        initViews()
        configureViews()
        configureActionBar()

        val networkConnected = NetWorkUtils.isNetworkConnected(this)
        if (networkConnected) {
            repositoriesPresenter!!.loadRepositoriesByUserLogin(userName!!)
            repositoryDao.deleteAllRepositories()
        } else {
            val repositories = repositoryDao.loadAllRepositories()
            repositoryAdapter = RepositoryAdapter(this, repositories)
            recyclerView.adapter = repositoryAdapter
            swipeRefreshLayout.isEnabled = false
        }


    }

    override fun onStartLoading() {
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Fetching Github Users...")
        progressDialog.setCancelable(false)
        progressDialog.show()
    }

    override fun loadRepositoriesByQuery(repositories: List<Repository>) {
        repositoryAdapter = RepositoryAdapter(applicationContext, repositories)
        recyclerView.adapter = repositoryAdapter
    }

    override fun onErrorLoadingRepositories(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
        onLoadingFinished()
    }

    override fun onLoadingFinished() {
        Toast.makeText(this, "Repositories are Loaded", Toast.LENGTH_SHORT).show()
        swipeRefreshLayout.isRefreshing = false
        progressDialog.hide()
        progressDialog.dismiss()
    }


    private fun initViews() {
        swipeRefreshLayout = findViewById(R.id.repo_swipeContainer) as SwipeRefreshLayout
        recyclerView = findViewById(R.id.repo_recyclerView) as RecyclerView
    }

    private fun configureViews() {

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        //recyclerView.smoothScrollToPosition(0);


        swipeRefreshLayout.setOnRefreshListener {
            repositoriesPresenter!!.loadRepositoriesByUserLogin(userName!!)
            Toast.makeText(this@MvpRepositoryActivity, "Github Users Refreshed", Toast.LENGTH_SHORT).show()
        }


    }

    private fun configureActionBar() {
        supportActionBar!!.title = "UserDbModel Repositories"
    }

    override fun onDestroy() {
        super.onDestroy()
        repositoriesPresenter!!.check_if_disposable_is_null_or_unsubscribe()
        repositoryDao.saveRepositories(repositoryAdapter!!.repositories)
        repositoryDao.closeConnection()
    }
}
