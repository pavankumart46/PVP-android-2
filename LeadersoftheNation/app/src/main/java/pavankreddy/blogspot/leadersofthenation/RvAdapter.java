package pavankreddy.blogspot.leadersofthenation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RvAdapter extends
        RecyclerView.Adapter<RvAdapter.ViewInfo>
{

    Context context;
    int images[];
    String leaders[],years[];


    public RvAdapter(Context context, int[] images, String[] leaders, String[] years) {
        this.context = context;
        this.images = images;
        this.leaders = leaders;
        this.years = years;
    }

    @NonNull
    @Override
    public ViewInfo onCreateViewHolder(@NonNull ViewGroup parent,
                                       int viewType) {
        View v = LayoutInflater
                .from(context)
                .inflate(R.layout.design,parent,false);
        ViewInfo vi = new ViewInfo(v);
        return vi;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewInfo holder,
                                 int position) {

        holder.iv.setImageResource(images[position]);
        holder.name.setText(leaders[position]);
        holder.years.setText(years[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewInfo extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView name,years;
        public ViewInfo(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.leader_image);
            name = itemView.findViewById(R.id.leader_name);
            years = itemView.findViewById(R.id.leader_years);
        }
    }
}