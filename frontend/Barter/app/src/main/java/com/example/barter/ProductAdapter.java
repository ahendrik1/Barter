package com.example.barter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.barter.model.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductAdapter extends ArrayAdapter<Product> {

    private Context pContext;
    private List<Product> productsList = new ArrayList<>();

    public ProductAdapter(Context context, ArrayList<Product> list) {
        super(context, 0 , list);
        pContext = context;
        productsList = list;
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(pContext).inflate(R.layout.item_product,parent,false);

        Product currentProduct = productsList.get(position);

        TextView pname = (TextView) listItem.findViewById(R.id.product_sell_name);
        pname.setText(currentProduct.getName());

        TextView pDesc = (TextView) listItem.findViewById(R.id.product_sell_description);
        pDesc.setText(currentProduct.getDescription());

        TextView pAge = (TextView) listItem.findViewById(R.id.product_sell_age);
        pAge.setText(currentProduct.getAge());

        TextView pBrand = (TextView) listItem.findViewById(R.id.product_sell_brand);
        pBrand.setText(currentProduct.getBrand());

        TextView pColor = (TextView) listItem.findViewById(R.id.product_sell_color);
        pColor.setText(currentProduct.getColor());

        return listItem;
    }
}