package sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import java.lang.Override;
import java.lang.Throwable;
import java.util.List;
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.repos_model.Repository;

public class RepositoriesView$$State extends MvpViewState<RepositoriesView> implements RepositoriesView {
	@Override
	public void onStartLoading() {
		OnStartLoadingCommand onStartLoadingCommand = new OnStartLoadingCommand();
		mViewCommands.beforeApply(onStartLoadingCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (RepositoriesView view : mViews) {
			view.onStartLoading();
		}

		mViewCommands.afterApply(onStartLoadingCommand);
	}

	@Override
	public void loadRepositoriesByQuery(List<Repository> repositories) {
		LoadRepositoriesByQueryCommand loadRepositoriesByQueryCommand = new LoadRepositoriesByQueryCommand(repositories);
		mViewCommands.beforeApply(loadRepositoriesByQueryCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (RepositoriesView view : mViews) {
			view.loadRepositoriesByQuery(repositories);
		}

		mViewCommands.afterApply(loadRepositoriesByQueryCommand);
	}

	@Override
	public void onErrorLoadingRepositories(Throwable throwable) {
		OnErrorLoadingRepositoriesCommand onErrorLoadingRepositoriesCommand = new OnErrorLoadingRepositoriesCommand(throwable);
		mViewCommands.beforeApply(onErrorLoadingRepositoriesCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (RepositoriesView view : mViews) {
			view.onErrorLoadingRepositories(throwable);
		}

		mViewCommands.afterApply(onErrorLoadingRepositoriesCommand);
	}

	@Override
	public void onLoadingFinished() {
		OnLoadingFinishedCommand onLoadingFinishedCommand = new OnLoadingFinishedCommand();
		mViewCommands.beforeApply(onLoadingFinishedCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (RepositoriesView view : mViews) {
			view.onLoadingFinished();
		}

		mViewCommands.afterApply(onLoadingFinishedCommand);
	}

	public class OnStartLoadingCommand extends ViewCommand<RepositoriesView> {
		OnStartLoadingCommand() {
			super("onStartLoading", AddToEndStrategy.class);
		}

		@Override
		public void apply(RepositoriesView mvpView) {
			mvpView.onStartLoading();
		}
	}

	public class LoadRepositoriesByQueryCommand extends ViewCommand<RepositoriesView> {
		public final List<Repository> repositories;

		LoadRepositoriesByQueryCommand(List<Repository> repositories) {
			super("loadRepositoriesByQuery", AddToEndStrategy.class);

			this.repositories = repositories;
		}

		@Override
		public void apply(RepositoriesView mvpView) {
			mvpView.loadRepositoriesByQuery(repositories);
		}
	}

	public class OnErrorLoadingRepositoriesCommand extends ViewCommand<RepositoriesView> {
		public final Throwable throwable;

		OnErrorLoadingRepositoriesCommand(Throwable throwable) {
			super("onErrorLoadingRepositories", AddToEndStrategy.class);

			this.throwable = throwable;
		}

		@Override
		public void apply(RepositoriesView mvpView) {
			mvpView.onErrorLoadingRepositories(throwable);
		}
	}

	public class OnLoadingFinishedCommand extends ViewCommand<RepositoriesView> {
		OnLoadingFinishedCommand() {
			super("onLoadingFinished", AddToEndStrategy.class);
		}

		@Override
		public void apply(RepositoriesView mvpView) {
			mvpView.onLoadingFinished();
		}
	}
}
