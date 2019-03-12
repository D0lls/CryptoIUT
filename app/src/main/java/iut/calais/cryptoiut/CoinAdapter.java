package iut.calais.cryptoiut;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.CoinViewHolder>  {
    private OnCoinClickListener listener;
    private List<CoinInfo> coinList;

    @NonNull
    @Override
    public CoinViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);

        return new CoinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinViewHolder coinViewHolder, int i) {
        CoinInfo CoinInfo = coinList.get(i);
        coinViewHolder.bind(listener,CoinInfo);


    }

    @Override
    public int getItemCount() {
        return null != coinList ? coinList.size() : 0;
    }

    class CoinViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewCoin, textViewRank, textViewValue;

        public CoinViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCoin = itemView.findViewById(R.id.text_view_coin);
            textViewRank = itemView.findViewById(R.id.text_view_rank);
            textViewValue = itemView.findViewById(R.id.textValue);

        }
        public void bind(final OnCoinClickListener listener, final CoinInfo CoinInfo) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onCoinClick(CoinInfo);
                }
            });
            textViewCoin.setText(CoinInfo.getId());
            textViewRank.setText(CoinInfo.getRank());
            textViewValue.setText(CoinInfo.getPriceUsd()+"$");
        }
    }

    public void setCoins(List<CoinInfo> coinList) {
        this.coinList = coinList;

    }

    public void setOnCoinClickListener(OnCoinClickListener listener) {

        this.listener = listener;
    }
}
