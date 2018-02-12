//package com.kesun.sqlite.realm;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.CheckBox;
//import android.widget.CompoundButton;
//import android.widget.ListAdapter;
//import android.widget.TextView;
//
//import com.kesun.sqlite.R;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import io.realm.OrderedRealmCollection;
//import io.realm.RealmBaseAdapter;
//
//class MyListAdapter extends RealmBaseAdapter<ItemInfo> implements ListAdapter {
//
//    private boolean inDeletionMode = false;
//    private Set<Integer> countersToDelete = new HashSet<Integer>();
//    private Context mContext;
//
//    public MyListAdapter(Context context, OrderedRealmCollection<ItemInfo> realmResults) {
//        super(context, realmResults);
//        this.mContext = context;
//    }
//
//    private void enableDeletionMode(boolean enabled) {
//        inDeletionMode = enabled;
//        if (!enabled) {
//            countersToDelete.clear();
//        }
//        notifyDataSetChanged();
//    }
//
//    Set<Integer> getCountersToDelete() {
//        return countersToDelete;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        /*ViewHolder viewHolder;
//        if (convertView == null) {
//            convertView = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.row, parent, false);
//            viewHolder = new ViewHolder();
//            viewHolder.countText = (TextView) convertView.findViewById(R.id.textview);
//            viewHolder.deleteCheckBox = (CheckBox) convertView.findViewById(R.id.checkBox);
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//
//        if (adapterData != null) {
//            final ItemInfo item = adapterData.get(position);
//            viewHolder.countText.setText(item.getCountString());
//            if (inDeletionMode) {
//                viewHolder.deleteCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                    @Override
//                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                        countersToDelete.add(item.getId());
//                    }
//                });
//            } else {
//                viewHolder.deleteCheckBox.setOnCheckedChangeListener(null);
//            }
//            viewHolder.deleteCheckBox.setChecked(countersToDelete.contains(item.getId()));
//            viewHolder.deleteCheckBox.setVisibility(inDeletionMode ? View.VISIBLE : View.GONE);
//        }*/
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_tx, null);
//        }
//        ViewHolder holder = (ViewHolder) convertView.getTag();
//        if (holder == null) {
//            holder = new ViewHolder();
//            holder.textView = (TextView) convertView.findViewById(R.id.textView);
//            convertView.setTag(holder);
//        }
//        ItemInfo itemInfo = adapterData.get(position);
//        holder.textView.setText(itemInfo.toString());
//
//        return convertView;
//    }
//
//    public class ViewHolder {
//        TextView textView;
//    }
//}