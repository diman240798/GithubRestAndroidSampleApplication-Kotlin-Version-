package sfedu.physics.dmitriy.githubapiresttestproject.mvp.users;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.disposables.Disposable;

@InjectViewState
public class UsersPresenter extends MvpPresenter<UsersView> {

    UsersModel usersModel;

    private final String initQuery = "language:java+location:russia";
    private String query = initQuery;
    private Disposable disposable;

    public UsersPresenter() {
        usersModel = new UsersModel();
    }


    public void loadUsersByLocationAndLanguage(String userLocation, String userProgrammingLanguage) {
        query = usersModel.createQueryByLocationAndLanguage(userLocation, userProgrammingLanguage);
        loadUsersByQuery();
    }

    public void check_if_disposable_is_null_or_unsubscribe() {
        if (disposable == null) {
            return;
        } else if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public void loadUsersByQuery() {
        getViewState().onStartLoading();
        check_if_disposable_is_null_or_unsubscribe();
        disposable = usersModel.loadUsersByQuery(query)
                .subscribe(getViewState()::loadUsersByQuery,
                        getViewState()::onErrorLoadingUsers,
                        getViewState()::onLoadingFinished);
    }

    public void loadMoreUsers(int pageNumber) {
        check_if_disposable_is_null_or_unsubscribe();
        disposable = usersModel.loadMoreUsers(query, pageNumber)
                .subscribe(getViewState()::loadMoreUsers,
                        getViewState()::onErrorLoadingUsers);
    }
}
