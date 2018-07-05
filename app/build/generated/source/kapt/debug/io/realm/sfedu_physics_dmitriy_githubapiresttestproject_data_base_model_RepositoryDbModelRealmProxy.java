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
public class sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxy extends sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel
    implements RealmObjectProxy, sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface {

    static final class RepositoryDbModelColumnInfo extends ColumnInfo {
        long nameIndex;
        long isPrivateIndex;
        long descriptionIndex;
        long languageIndex;
        long clone_urlIndex;
        long html_urlIndex;

        RepositoryDbModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RepositoryDbModel");
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.isPrivateIndex = addColumnDetails("isPrivate", "isPrivate", objectSchemaInfo);
            this.descriptionIndex = addColumnDetails("description", "description", objectSchemaInfo);
            this.languageIndex = addColumnDetails("language", "language", objectSchemaInfo);
            this.clone_urlIndex = addColumnDetails("clone_url", "clone_url", objectSchemaInfo);
            this.html_urlIndex = addColumnDetails("html_url", "html_url", objectSchemaInfo);
        }

        RepositoryDbModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RepositoryDbModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RepositoryDbModelColumnInfo src = (RepositoryDbModelColumnInfo) rawSrc;
            final RepositoryDbModelColumnInfo dst = (RepositoryDbModelColumnInfo) rawDst;
            dst.nameIndex = src.nameIndex;
            dst.isPrivateIndex = src.isPrivateIndex;
            dst.descriptionIndex = src.descriptionIndex;
            dst.languageIndex = src.languageIndex;
            dst.clone_urlIndex = src.clone_urlIndex;
            dst.html_urlIndex = src.html_urlIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private RepositoryDbModelColumnInfo columnInfo;
    private ProxyState<sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel> proxyState;

    sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RepositoryDbModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isPrivate() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isPrivateIndex);
    }

    @Override
    public void realmSet$isPrivate(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isPrivateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isPrivateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descriptionIndex);
    }

    @Override
    public void realmSet$description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descriptionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descriptionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descriptionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$language() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.languageIndex);
    }

    @Override
    public void realmSet$language(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.languageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.languageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.languageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.languageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$clone_url() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.clone_urlIndex);
    }

    @Override
    public void realmSet$clone_url(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.clone_urlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.clone_urlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.clone_urlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.clone_urlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$html_url() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.html_urlIndex);
    }

    @Override
    public void realmSet$html_url(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.html_urlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.html_urlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.html_urlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.html_urlIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RepositoryDbModel", 6, 0);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("isPrivate", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("language", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("clone_url", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("html_url", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RepositoryDbModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RepositoryDbModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RepositoryDbModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RepositoryDbModel";
    }

    @SuppressWarnings("cast")
    public static sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel obj = realm.createObjectInternal(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel.class, true, excludeFields);

        final sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface objProxy = (sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("isPrivate")) {
            if (json.isNull("isPrivate")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isPrivate' to null.");
            } else {
                objProxy.realmSet$isPrivate((boolean) json.getBoolean("isPrivate"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                objProxy.realmSet$description(null);
            } else {
                objProxy.realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("language")) {
            if (json.isNull("language")) {
                objProxy.realmSet$language(null);
            } else {
                objProxy.realmSet$language((String) json.getString("language"));
            }
        }
        if (json.has("clone_url")) {
            if (json.isNull("clone_url")) {
                objProxy.realmSet$clone_url(null);
            } else {
                objProxy.realmSet$clone_url((String) json.getString("clone_url"));
            }
        }
        if (json.has("html_url")) {
            if (json.isNull("html_url")) {
                objProxy.realmSet$html_url(null);
            } else {
                objProxy.realmSet$html_url((String) json.getString("html_url"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel obj = new sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel();
        final sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface objProxy = (sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("isPrivate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isPrivate((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isPrivate' to null.");
                }
            } else if (name.equals("description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$description(null);
                }
            } else if (name.equals("language")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$language((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$language(null);
                }
            } else if (name.equals("clone_url")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clone_url((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$clone_url(null);
                }
            } else if (name.equals("html_url")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$html_url((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$html_url(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel copyOrUpdate(Realm realm, sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel copy(Realm realm, sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel realmObject = realm.createObjectInternal(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface realmObjectSource = (sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) newObject;
        sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface realmObjectCopy = (sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$isPrivate(realmObjectSource.realmGet$isPrivate());
        realmObjectCopy.realmSet$description(realmObjectSource.realmGet$description());
        realmObjectCopy.realmSet$language(realmObjectSource.realmGet$language());
        realmObjectCopy.realmSet$clone_url(realmObjectSource.realmGet$clone_url());
        realmObjectCopy.realmSet$html_url(realmObjectSource.realmGet$html_url());
        return realmObject;
    }

    public static long insert(Realm realm, sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel.class);
        long tableNativePtr = table.getNativePtr();
        RepositoryDbModelColumnInfo columnInfo = (RepositoryDbModelColumnInfo) realm.getSchema().getColumnInfo(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$name = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isPrivateIndex, rowIndex, ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$isPrivate(), false);
        String realmGet$description = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }
        String realmGet$language = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$language();
        if (realmGet$language != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.languageIndex, rowIndex, realmGet$language, false);
        }
        String realmGet$clone_url = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$clone_url();
        if (realmGet$clone_url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.clone_urlIndex, rowIndex, realmGet$clone_url, false);
        }
        String realmGet$html_url = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$html_url();
        if (realmGet$html_url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.html_urlIndex, rowIndex, realmGet$html_url, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel.class);
        long tableNativePtr = table.getNativePtr();
        RepositoryDbModelColumnInfo columnInfo = (RepositoryDbModelColumnInfo) realm.getSchema().getColumnInfo(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel.class);
        sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel object = null;
        while (objects.hasNext()) {
            object = (sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$name = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isPrivateIndex, rowIndex, ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$isPrivate(), false);
            String realmGet$description = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            }
            String realmGet$language = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$language();
            if (realmGet$language != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.languageIndex, rowIndex, realmGet$language, false);
            }
            String realmGet$clone_url = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$clone_url();
            if (realmGet$clone_url != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.clone_urlIndex, rowIndex, realmGet$clone_url, false);
            }
            String realmGet$html_url = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$html_url();
            if (realmGet$html_url != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.html_urlIndex, rowIndex, realmGet$html_url, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel.class);
        long tableNativePtr = table.getNativePtr();
        RepositoryDbModelColumnInfo columnInfo = (RepositoryDbModelColumnInfo) realm.getSchema().getColumnInfo(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$name = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isPrivateIndex, rowIndex, ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$isPrivate(), false);
        String realmGet$description = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }
        String realmGet$language = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$language();
        if (realmGet$language != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.languageIndex, rowIndex, realmGet$language, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.languageIndex, rowIndex, false);
        }
        String realmGet$clone_url = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$clone_url();
        if (realmGet$clone_url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.clone_urlIndex, rowIndex, realmGet$clone_url, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.clone_urlIndex, rowIndex, false);
        }
        String realmGet$html_url = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$html_url();
        if (realmGet$html_url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.html_urlIndex, rowIndex, realmGet$html_url, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.html_urlIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel.class);
        long tableNativePtr = table.getNativePtr();
        RepositoryDbModelColumnInfo columnInfo = (RepositoryDbModelColumnInfo) realm.getSchema().getColumnInfo(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel.class);
        sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel object = null;
        while (objects.hasNext()) {
            object = (sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$name = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isPrivateIndex, rowIndex, ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$isPrivate(), false);
            String realmGet$description = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
            }
            String realmGet$language = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$language();
            if (realmGet$language != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.languageIndex, rowIndex, realmGet$language, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.languageIndex, rowIndex, false);
            }
            String realmGet$clone_url = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$clone_url();
            if (realmGet$clone_url != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.clone_urlIndex, rowIndex, realmGet$clone_url, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.clone_urlIndex, rowIndex, false);
            }
            String realmGet$html_url = ((sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) object).realmGet$html_url();
            if (realmGet$html_url != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.html_urlIndex, rowIndex, realmGet$html_url, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.html_urlIndex, rowIndex, false);
            }
        }
    }

    public static sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel createDetachedCopy(sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel) cachedObject.object;
            }
            unmanagedObject = (sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface unmanagedCopy = (sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) unmanagedObject;
        sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface realmSource = (sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$isPrivate(realmSource.realmGet$isPrivate());
        unmanagedCopy.realmSet$description(realmSource.realmGet$description());
        unmanagedCopy.realmSet$language(realmSource.realmGet$language());
        unmanagedCopy.realmSet$clone_url(realmSource.realmGet$clone_url());
        unmanagedCopy.realmSet$html_url(realmSource.realmGet$html_url());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RepositoryDbModel = proxy[");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isPrivate:");
        stringBuilder.append(realmGet$isPrivate());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{language:");
        stringBuilder.append(realmGet$language() != null ? realmGet$language() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clone_url:");
        stringBuilder.append(realmGet$clone_url() != null ? realmGet$clone_url() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{html_url:");
        stringBuilder.append(realmGet$html_url() != null ? realmGet$html_url() : "null");
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
        sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxy aRepositoryDbModel = (sfedu_physics_dmitriy_githubapiresttestproject_data_base_model_RepositoryDbModelRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRepositoryDbModel.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRepositoryDbModel.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRepositoryDbModel.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
