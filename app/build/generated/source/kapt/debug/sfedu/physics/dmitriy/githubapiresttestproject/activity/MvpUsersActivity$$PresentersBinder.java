package sfedu.physics.dmitriy.githubapiresttestproject.activity;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;
import sfedu.physics.dmitriy.githubapiresttestproject.mvp.users.UsersPresenter;

public class MvpUsersActivity$$PresentersBinder extends PresenterBinder<MvpUsersActivity> {
	@Override
	public List<PresenterField<MvpUsersActivity>> getPresenterFields() {
		List<PresenterField<MvpUsersActivity>> presenters = new ArrayList<>(1);
		presenters.add(new usersPresenterBinder());
		return presenters;
	}

	public class usersPresenterBinder extends PresenterField<MvpUsersActivity> {
		public usersPresenterBinder() {
			super("usersPresenter", PresenterType.LOCAL, null, UsersPresenter.class);
		}

		@Override
		public void bind(MvpUsersActivity target, MvpPresenter presenter) {
			target.usersPresenter = (UsersPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(MvpUsersActivity delegated) {
			return new UsersPresenter();
		}
	}
}
