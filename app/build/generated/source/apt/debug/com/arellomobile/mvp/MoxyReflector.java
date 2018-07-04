package com.arellomobile.mvp;

import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import java.lang.Class;
import java.lang.Object;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sfedu.physics.dmitriy.githubapiresttestproject.activity.MvpRepositoryActivity;
import sfedu.physics.dmitriy.githubapiresttestproject.activity.MvpRepositoryActivity$$PresentersBinder;
import sfedu.physics.dmitriy.githubapiresttestproject.activity.MvpUsersActivity;
import sfedu.physics.dmitriy.githubapiresttestproject.activity.MvpUsersActivity$$PresentersBinder;
import sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries.RepositoriesPresenter;
import sfedu.physics.dmitriy.githubapiresttestproject.mvp.repositpries.RepositoriesPresenter$$ViewStateProvider;
import sfedu.physics.dmitriy.githubapiresttestproject.mvp.users.UsersPresenter;
import sfedu.physics.dmitriy.githubapiresttestproject.mvp.users.UsersPresenter$$ViewStateProvider;

public final class MoxyReflector {
	private static Map<Class<?>, Object> sViewStateProviders;

	private static Map<Class<?>, List<Object>> sPresenterBinders;

	private static Map<Class<?>, Object> sStrategies;

	static {
		sViewStateProviders = new HashMap<>();
		sViewStateProviders.put(RepositoriesPresenter.class, new RepositoriesPresenter$$ViewStateProvider());
		sViewStateProviders.put(UsersPresenter.class, new UsersPresenter$$ViewStateProvider());

		sPresenterBinders = new HashMap<>();
		sPresenterBinders.put(MvpRepositoryActivity.class, Arrays.<Object>asList(new MvpRepositoryActivity$$PresentersBinder()));
		sPresenterBinders.put(MvpUsersActivity.class, Arrays.<Object>asList(new MvpUsersActivity$$PresentersBinder()));

		sStrategies = new HashMap<>();
		sStrategies.put(AddToEndStrategy.class, new AddToEndStrategy());
	}

	public static Object getViewState(Class<?> presenterClass) {
		ViewStateProvider viewStateProvider = (ViewStateProvider) sViewStateProviders.get(presenterClass);
		if (viewStateProvider == null) {
			return null;
		}

		return viewStateProvider.getViewState();
	}

	public static List<Object> getPresenterBinders(Class<?> delegated) {
		return sPresenterBinders.get(delegated);
	}

	public static Object getStrategy(Class<?> strategyClass) {
		return sStrategies.get(strategyClass);
	}
}
