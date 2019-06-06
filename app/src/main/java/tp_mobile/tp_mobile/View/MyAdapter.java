package tp_mobile.tp_mobile.View;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

import tp_mobile.tp_mobile.Model.Cat;
import tp_mobile.tp_mobile.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Cat> values;
    private final Context context;
    private final OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(Cat item);
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View layout;
        public ImageView image;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            image = v.findViewById(R.id.icon);
        }
    }

    public void add(int position, Cat item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Cat> myDataset, Context context, OnItemClickListener listener) {
        this.listener = listener;
        this.context = context;
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Cat currentCat = values.get(position);
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.image.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(currentCat);
            }
        });
        Picasso.with(context).load(currentCat.getUrl()).into(holder.image);
//        holder.txtFooter.setText("Footer: " + currentCat.getUrl());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }
}