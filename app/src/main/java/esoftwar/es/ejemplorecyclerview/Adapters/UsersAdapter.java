package esoftwar.es.ejemplorecyclerview.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import esoftwar.es.ejemplorecyclerview.R;
import esoftwar.es.ejemplorecyclerview.models.User;

/**
 * Created by FranPC on 18/07/2017.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private List<User> userList;

    /**
     * Constructor
     * @param userList List of User model
     */
    public UsersAdapter(List<User> userList) {
        this.userList = userList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate( R.layout.users_item_recyclerview, parent, false );
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind( userList.get(position) );
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return userList.size();
    }

    // Inner class
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Widget of item
        public TextView textNameUser, textAgeUser;
        public CardView cardView;
        public Button button;

        // Constructor
        public ViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            textNameUser = (TextView) itemView.findViewById(R.id.textNameUser);
            textAgeUser = (TextView) itemView.findViewById(R.id.textAgeUser);
            button = (Button) itemView.findViewById(R.id.buttonSee);

            cardView.setOnClickListener(this);
            button.setOnClickListener(this);
        }


        /**
         * Vuelca los datos de User en la interface.
         */
        public void bind(User user) {

            final String userName = "<strong>" + user.getName() + "</strong>";
            final String ageName = "Age: <strong>" + String.valueOf(user.getAge()) + "</strong>";

            textNameUser.setText( Html.fromHtml(userName.toUpperCase()));
            textAgeUser.setText( Html.fromHtml(ageName) );
        }

        @Override
        public void onClick(View view) {
            Log.i( "CLICK_IN", view.getId() == R.id.buttonSee ? "Button" : "Not Button" );
            Log.i( "CLICK_IN", view.getId() == R.id.cardView ? "CardView" : "Not CardView" );
        }
    }


}
