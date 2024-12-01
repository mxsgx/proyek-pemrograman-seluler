package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private final LayoutInflater layoutInflaterManager;
    private List<ContactModel> contactModelList;
    private LayoutInflater layoutInflater;
    private Context context;
    final ContactAdapter.OnItemClickListener onItemClickListener;

    public ContactAdapter(List<ContactModel> contactModelList, Context context, ContactAdapter.OnItemClickListener onItemClickListener) {
        this.layoutInflaterManager = LayoutInflater.from(context);
        this.contactModelList = contactModelList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ContactAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflaterManager.inflate(R.layout.contact_item, null);

        return new ContactAdapter.ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.bindData(contactModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return contactModelList.size();
    }

    public void setItem(List<ContactModel> items) {
        contactModelList = items;
    }

    public interface OnItemClickListener {
        void onItemClick(ContactModel item);
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, phoneNumberTextView, statusTextView;
        ImageView avatarImageView;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            avatarImageView = itemView.findViewById(R.id.contact_avatar);
            nameTextView = itemView.findViewById(R.id.contact_name);
            phoneNumberTextView = itemView.findViewById(R.id.contact_phone_number);
            statusTextView = itemView.findViewById(R.id.contact_status);
        }

        public void bindData(final ContactModel data) {
            avatarImageView.setColorFilter(Color.parseColor(data.getColor()), PorterDuff.Mode.SRC_IN);
            nameTextView.setText(data.getName());
            phoneNumberTextView.setText(data.getPhoneNumber());
            statusTextView.setText(data.getStatus());

            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(data));
        }
    }
}
