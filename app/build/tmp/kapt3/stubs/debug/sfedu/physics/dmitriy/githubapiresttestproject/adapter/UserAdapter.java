package sfedu.physics.dmitriy.githubapiresttestproject.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001d\u001eB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0006\u0010\u001b\u001a\u00020\u0011J\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001f"}, d2 = {"Lsfedu/physics/dmitriy/githubapiresttestproject/adapter/UserAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lsfedu/physics/dmitriy/githubapiresttestproject/adapter/UserAdapter$ViewHolder;", "context", "Landroid/content/Context;", "users", "", "Lsfedu/physics/dmitriy/githubapiresttestproject/json_model/user_model/User;", "(Landroid/content/Context;Ljava/util/List;)V", "isLoading", "", "noMore", "onLoadMoreListener", "Lsfedu/physics/dmitriy/githubapiresttestproject/adapter/UserAdapter$OnLoadMoreListener;", "getUsers", "()Ljava/util/List;", "endLoading", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setNoMore", "setOnLoadMoreListener", "OnLoadMoreListener", "ViewHolder", "app_debug"})
public final class UserAdapter extends android.support.v7.widget.RecyclerView.Adapter<sfedu.physics.dmitriy.githubapiresttestproject.adapter.UserAdapter.ViewHolder> {
    private sfedu.physics.dmitriy.githubapiresttestproject.adapter.UserAdapter.OnLoadMoreListener onLoadMoreListener;
    private boolean isLoading;
    private boolean noMore;
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.User> users = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public sfedu.physics.dmitriy.githubapiresttestproject.adapter.UserAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    sfedu.physics.dmitriy.githubapiresttestproject.adapter.UserAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void setOnLoadMoreListener(@org.jetbrains.annotations.NotNull()
    sfedu.physics.dmitriy.githubapiresttestproject.adapter.UserAdapter.OnLoadMoreListener onLoadMoreListener) {
    }
    
    public final void endLoading() {
    }
    
    public final void setNoMore() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.User> getUsers() {
        return null;
    }
    
    public UserAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.User> users) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lsfedu/physics/dmitriy/githubapiresttestproject/adapter/UserAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lsfedu/physics/dmitriy/githubapiresttestproject/adapter/UserAdapter;Landroid/view/View;)V", "avatarIV", "Landroid/widget/ImageView;", "getAvatarIV", "()Landroid/widget/ImageView;", "githubLink", "Landroid/widget/TextView;", "getGithubLink", "()Landroid/widget/TextView;", "title", "getTitle", "app_debug"})
    public final class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView title = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView githubLink = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView avatarIV = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getGithubLink() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getAvatarIV() {
            return null;
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lsfedu/physics/dmitriy/githubapiresttestproject/adapter/UserAdapter$OnLoadMoreListener;", "", "onLoadMore", "", "app_debug"})
    public static abstract interface OnLoadMoreListener {
        
        public abstract void onLoadMore();
    }
}