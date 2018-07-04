package sfedu.physics.dmitriy.githubapiresttestproject.mvp.users;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import java.lang.Override;
import java.lang.Throwable;
import sfedu.physics.dmitriy.githubapiresttestproject.user_model.UserResponse;

public class UsersView$$State extends MvpViewState<UsersView> implements UsersView {
	@Override
	public void onStartLoading() {
		OnStartLoadingCommand onStartLoadingCommand = new OnStartLoadingCommand();
		mViewCommands.beforeApply(onStartLoadingCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (UsersView view : mViews) {
			view.onStartLoading();
		}

		mViewCommands.afterApply(onStartLoadingCommand);
	}

	@Override
	public void loadUsersByQuery(UserResponse userResponse) {
		LoadUsersByQueryCommand loadUsersByQueryCommand = new LoadUsersByQueryCommand(userResponse);
		mViewCommands.beforeApply(loadUsersByQueryCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (UsersView view : mViews) {
			view.loadUsersByQuery(userResponse);
		}

		mViewCommands.afterApply(loadUsersByQueryCommand);
	}

	@Override
	public void onErrorLoadingUsers(Throwable throwable) {
		OnErrorLoadingUsersCommand onErrorLoadingUsersCommand = new OnErrorLoadingUsersCommand(throwable);
		mViewCommands.beforeApply(onErrorLoadingUsersCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (UsersView view : mViews) {
			view.onErrorLoadingUsers(throwable);
		}

		mViewCommands.afterApply(onErrorLoadingUsersCommand);
	}

	@Override
	public void onLoadingFinished() {
		OnLoadingFinishedCommand onLoadingFinishedCommand = new OnLoadingFinishedCommand();
		mViewCommands.beforeApply(onLoadingFinishedCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (UsersView view : mViews) {
			view.onLoadingFinished();
		}

		mViewCommands.afterApply(onLoadingFinishedCommand);
	}

	@Override
	public void loadMoreUsers(UserResponse userResponse) {
		LoadMoreUsersCommand loadMoreUsersCommand = new LoadMoreUsersCommand(userResponse);
		mViewCommands.beforeApply(loadMoreUsersCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (UsersView view : mViews) {
			view.loadMoreUsers(userResponse);
		}

		mViewCommands.afterApply(loadMoreUsersCommand);
	}

	public class OnStartLoadingCommand extends ViewCommand<UsersView> {
		OnStartLoadingCommand() {
			super("onStartLoading", AddToEndStrategy.class);
		}

		@Override
		public void apply(UsersView mvpView) {
			mvpView.onStartLoading();
		}
	}

	public class LoadUsersByQueryCommand extends ViewCommand<UsersView> {
		public final UserResponse userResponse;

		LoadUsersByQueryCommand(UserResponse userResponse) {
			super("loadUsersByQuery", AddToEndStrategy.class);

			this.userResponse = userResponse;
		}

		@Override
		public void apply(UsersView mvpView) {
			mvpView.loadUsersByQuery(userResponse);
		}
	}

	public class OnErrorLoadingUsersCommand extends ViewCommand<UsersView> {
		public final Throwable throwable;

		OnErrorLoadingUsersCommand(Throwable throwable) {
			super("onErrorLoadingUsers", AddToEndStrategy.class);

			this.throwable = throwable;
		}

		@Override
		public void apply(UsersView mvpView) {
			mvpView.onErrorLoadingUsers(throwable);
		}
	}

	public class OnLoadingFinishedCommand extends ViewCommand<UsersView> {
		OnLoadingFinishedCommand() {
			super("onLoadingFinished", AddToEndStrategy.class);
		}

		@Override
		public void apply(UsersView mvpView) {
			mvpView.onLoadingFinished();
		}
	}

	public class LoadMoreUsersCommand extends ViewCommand<UsersView> {
		public final UserResponse userResponse;

		LoadMoreUsersCommand(UserResponse userResponse) {
			super("loadMoreUsers", AddToEndStrategy.class);

			this.userResponse = userResponse;
		}

		@Override
		public void apply(UsersView mvpView) {
			mvpView.loadMoreUsers(userResponse);
		}
	}
}
