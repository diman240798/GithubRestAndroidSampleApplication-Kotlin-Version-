package sfedu.physics.dmitriy.githubapiresttestproject.mvp.users;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.ViewStateProvider;
import com.arellomobile.mvp.viewstate.MvpViewState;
import java.lang.Override;

public class UsersPresenter$$ViewStateProvider extends ViewStateProvider {
	@Override
	public MvpViewState<? extends MvpView> getViewState() {
		return new UsersView$$State();
	}
}
