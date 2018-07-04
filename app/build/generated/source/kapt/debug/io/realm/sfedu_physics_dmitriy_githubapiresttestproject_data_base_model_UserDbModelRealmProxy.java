package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxy extends sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel
    implements RealmObjectProxy, sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface {

    static final class UserDbModelColumnInfo extends ColumnInfo {
        long loginIndex;
        long htmlURLIndex;
        long bitmapDataIndex;

        UserDbModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("UserDbModel");
            this.loginIndex = addColumnDetails("login", "login", objectSchemaInfo);
            this.htmlURLIndex = addColumnDetails("htmlURL", "htmlURL", objectSchemaInfo);
            this.bitmapDataIndex = addColumnDetails("bitmapData", "bitmapData", objectSchemaInfo);
        }

        UserDbModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserDbModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserDbModelColumnInfo src = (UserDbModelColumnInfo) rawSrc;
            final UserDbModelColumnInfo dst = (UserDbModelColumnInfo) rawDst;
            dst.loginIndex = src.loginIndex;
            dst.htmlURLIndex = src.htmlURLIndex;
            dst.bitmapDataIndex = src.bitmapDataIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserDbModelColumnInfo columnInfo;
    private ProxyState<sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel> proxyState;

    sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserDbModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$login() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.loginIndex);
    }

    @Override
    public void realmSet$login(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.loginIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.loginIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.loginIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.loginIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$htmlURL() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.htmlURLIndex);
    }

    @Override
    public void realmSet$htmlURL(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.htmlURLIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.htmlURLIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.htmlURLIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.htmlURLIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public byte[] realmGet$bitmapData() {
        proxyState.getRealm$realm().checkIfValid();
        return (byte[]) proxyState.getRow$realm().getBinaryByteArray(columnInfo.bitmapDataIndex);
    }

    @Override
    public void realmSet$bitmapData(byte[] value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.bitmapDataIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBinaryByteArray(columnInfo.bitmapDataIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.bitmapDataIndex);
            return;
        }
        proxyState.getRow$realm().setBinaryByteArray(columnInfo.bitmapDataIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("UserDbModel", 3, 0);
        builder.addPersistedProperty("login", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("htmlURL", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("bitmapData", RealmFieldType.BINARY, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserDbModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserDbModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "UserDbModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "UserDbModel";
    }

    @SuppressWarnings("cast")
    public static sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel obj = realm.createObjectInternal(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel.class, true, excludeFields);

        final sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface objProxy = (sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) obj;
        if (json.has("login")) {
            if (json.isNull("login")) {
                objProxy.realmSet$login(null);
            } else {
                objProxy.realmSet$login((String) json.getString("login"));
            }
        }
        if (json.has("htmlURL")) {
            if (json.isNull("htmlURL")) {
                objProxy.realmSet$htmlURL(null);
            } else {
                objProxy.realmSet$htmlURL((String) json.getString("htmlURL"));
            }
        }
        if (json.has("bitmapData")) {
            if (json.isNull("bitmapData")) {
                objProxy.realmSet$bitmapData(null);
            } else {
                objProxy.realmSet$bitmapData(JsonUtils.stringToBytes(json.getString("bitmapData")));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel obj = new sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel();
        final sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface objProxy = (sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("login")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$login((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$login(null);
                }
            } else if (name.equals("htmlURL")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$htmlURL((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$htmlURL(null);
                }
            } else if (name.equals("bitmapData")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$bitmapData(JsonUtils.stringToBytes(reader.nextString()));
                } else {
                    reader.skipValue();
                    objProxy.realmSet$bitmapData(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel copyOrUpdate(Realm realm, sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel copy(Realm realm, sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel realmObject = realm.createObjectInternal(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface realmObjectSource = (sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) newObject;
        sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface realmObjectCopy = (sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$login(realmObjectSource.realmGet$login());
        realmObjectCopy.realmSet$htmlURL(realmObjectSource.realmGet$htmlURL());
        realmObjectCopy.realmSet$bitmapData(realmObjectSource.realmGet$bitmapData());
        return realmObject;
    }

    public static long insert(Realm realm, sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel.class);
        long tableNativePtr = table.getNativePtr();
        UserDbModelColumnInfo columnInfo = (UserDbModelColumnInfo) realm.getSchema().getColumnInfo(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$login = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) object).realmGet$login();
        if (realmGet$login != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
        }
        String realmGet$htmlURL = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) object).realmGet$htmlURL();
        if (realmGet$htmlURL != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.htmlURLIndex, rowIndex, realmGet$htmlURL, false);
        }
        byte[] realmGet$bitmapData = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) object).realmGet$bitmapData();
        if (realmGet$bitmapData != null) {
            Table.nativeSetByteArray(tableNativePtr, columnInfo.bitmapDataIndex, rowIndex, realmGet$bitmapData, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel.class);
        long tableNativePtr = table.getNativePtr();
        UserDbModelColumnInfo columnInfo = (UserDbModelColumnInfo) realm.getSchema().getColumnInfo(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel.class);
        sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel object = null;
        while (objects.hasNext()) {
            object = (sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$login = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) object).realmGet$login();
            if (realmGet$login != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
            }
            String realmGet$htmlURL = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) object).realmGet$htmlURL();
            if (realmGet$htmlURL != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.htmlURLIndex, rowIndex, realmGet$htmlURL, false);
            }
            byte[] realmGet$bitmapData = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) object).realmGet$bitmapData();
            if (realmGet$bitmapData != null) {
                Table.nativeSetByteArray(tableNativePtr, columnInfo.bitmapDataIndex, rowIndex, realmGet$bitmapData, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel.class);
        long tableNativePtr = table.getNativePtr();
        UserDbModelColumnInfo columnInfo = (UserDbModelColumnInfo) realm.getSchema().getColumnInfo(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$login = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) object).realmGet$login();
        if (realmGet$login != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.loginIndex, rowIndex, false);
        }
        String realmGet$htmlURL = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) object).realmGet$htmlURL();
        if (realmGet$htmlURL != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.htmlURLIndex, rowIndex, realmGet$htmlURL, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.htmlURLIndex, rowIndex, false);
        }
        byte[] realmGet$bitmapData = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) object).realmGet$bitmapData();
        if (realmGet$bitmapData != null) {
            Table.nativeSetByteArray(tableNativePtr, columnInfo.bitmapDataIndex, rowIndex, realmGet$bitmapData, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.bitmapDataIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel.class);
        long tableNativePtr = table.getNativePtr();
        UserDbModelColumnInfo columnInfo = (UserDbModelColumnInfo) realm.getSchema().getColumnInfo(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel.class);
        sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel object = null;
        while (objects.hasNext()) {
            object = (sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$login = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) object).realmGet$login();
            if (realmGet$login != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.loginIndex, rowIndex, false);
            }
            String realmGet$htmlURL = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) object).realmGet$htmlURL();
            if (realmGet$htmlURL != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.htmlURLIndex, rowIndex, realmGet$htmlURL, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.htmlURLIndex, rowIndex, false);
            }
            byte[] realmGet$bitmapData = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) object).realmGet$bitmapData();
            if (realmGet$bitmapData != null) {
                Table.nativeSetByteArray(tableNativePtr, columnInfo.bitmapDataIndex, rowIndex, realmGet$bitmapData, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.bitmapDataIndex, rowIndex, false);
            }
        }
    }

    public static sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel createDetachedCopy(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel) cachedObject.object;
            }
            unmanagedObject = (sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface unmanagedCopy = (sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) unmanagedObject;
        sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface realmSource = (sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$login(realmSource.realmGet$login());
        unmanagedCopy.realmSet$htmlURL(realmSource.realmGet$htmlURL());
        unmanagedCopy.realmSet$bitmapData(realmSource.realmGet$bitmapData());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("UserDbModel = proxy[");
        stringBuilder.append("{login:");
        stringBuilder.append(realmGet$login() != null ? realmGet$login() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{htmlURL:");
        stringBuilder.append(realmGet$htmlURL() != null ? realmGet$htmlURL() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bitmapData:");
        stringBuilder.append(realmGet$bitmapData() != null ? realmGet$bitmapData() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxy aUserDbModel = (sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_UserDbModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUserDbModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUserDbModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUserDbModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
