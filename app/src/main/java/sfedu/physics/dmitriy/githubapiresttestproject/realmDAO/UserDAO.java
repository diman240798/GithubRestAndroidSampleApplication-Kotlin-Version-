package sfedu.physics.dmitriy.githubapiresttestproject.realmDAO;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel;
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.User;

public class UserDAO {
    private final Realm realm;

    {
        realm = Realm.getDefaultInstance();
    }

    public void deleteAllUsers() {
        realm.beginTransaction();
        realm.delete(UserDbModel.class);
        realm.commitTransaction();
    }

    public void saveUsers(List<User> users) {
        realm.beginTransaction();
        for (User user : users) {
            UserDbModel userDbModel = realm.createObject(UserDbModel.class);
            userDbModel.setLogin(user.getLogin());
            userDbModel.setBitmapData(user.getBitmapData());
            userDbModel.setHtmlURL(user.getHtmlURL());
        }
        realm.commitTransaction();
    }

    public List<User> loadAllUsers() {
        RealmResults<UserDbModel> userModels = realm.where(UserDbModel.class).findAll();
        List<User> users = new ArrayList<>();
        for (UserDbModel userDbModel : userModels) {
            User user = new User();
            user.setBitmapData(userDbModel.getBitmapData());
            user.setHtmlURL(userDbModel.getHtmlURL());
            user.setLogin(userDbModel.getLogin());
            users.add(user);
        }
        return users;
    }

    public void closeConnection() {
        realm.close();
    }
}
