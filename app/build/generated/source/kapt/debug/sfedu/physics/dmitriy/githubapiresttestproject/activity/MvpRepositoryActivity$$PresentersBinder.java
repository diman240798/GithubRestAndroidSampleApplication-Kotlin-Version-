package sfedu.physics.dmitriy.githubapiresttestproject.activity;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;
import sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries.RepositoriesPresenter;

public class MvpRepositoryActivity$$PresentersBinder extends PresenterBinder<MvpRepositoryActivity> {
	@Override
	public List<PresenterField<MvpRepositoryActivity>> getPresenterFields() {
		List<PresenterField<MvpRepositoryActivity>> presenters = new ArrayList<>(1);
		presenters.add(new repositoriesPresenterBinder());
		return presenters;
	}

	public class repositoriesPresenterBinder extends PresenterField<MvpRepositoryActivity> {
		public repositoriesPresenterBinder() {
			super("repositoriesPresenter", PresenterType.LOCAL, null, RepositoriesPresenter.class);
		}

		@Override
		public void bind(MvpRepositoryActivity target, MvpPresenter presenter) {
			target.repositoriesPresenter = (RepositoriesPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(MvpRepositoryActivity delegated) {
			return new RepositoriesPresenter();
		}
	}
}
