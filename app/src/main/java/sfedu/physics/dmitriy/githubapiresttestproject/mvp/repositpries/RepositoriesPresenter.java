package sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.disposables.Disposable;

@InjectViewState
public class RepositoriesPresenter extends MvpPresenter<RepositoriesView> {

    private final RepositoriesModel repositoriesModel;
    private Disposable disposable;


    public RepositoriesPresenter() {
        repositoriesModel = new RepositoriesModel();
    }



    public void loadRepositoriesByUserLogin(String userLogin) {
        getViewState().onStartLoading();
        check_if_disposable_is_null_or_unsubscribe();
        disposable = repositoriesModel.loadRepositories(userLogin)
                .subscribe(getViewState()::loadRepositoriesByQuery,
                        getViewState()::onErrorLoadingRepositories,
                        getViewState()::onLoadingFinished);
    }

    public void check_if_disposable_is_null_or_unsubscribe() {
        if (disposable == null) {
            return;
        } else if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }


}