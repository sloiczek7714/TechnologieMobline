package wb.tm.technologiemobline;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<PersonsTable> dataPersonList;
    private Context conetxt;
    private LayoutInflater inflater;

    public RecyclerAdapter(Context context, List<PersonsTable> dataPersonList) {
        this.dataPersonList = dataPersonList;
        this.conetxt = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.person_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.tvSurname.setText(dataPersonList.get(position).getSurname());
        holder.tvName.setText(dataPersonList.get(position).getName());
        holder.tvRank.setText(dataPersonList.get(position).getRank());
        holder.tvTableNumber.setText(dataPersonList.get(position).getTableNumber());

    }

    @Override
    public int getItemCount() {
        return dataPersonList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvSurname;
        private TextView tvName;
        private TextView tvTableNumber;
        private TextView tvRank;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.name);
            tvSurname = itemView.findViewById(R.id.surname);
            tvTableNumber = itemView.findViewById(R.id.tableNumber);
            tvRank = itemView.findViewById(R.id.rank);

        }


    }

}
