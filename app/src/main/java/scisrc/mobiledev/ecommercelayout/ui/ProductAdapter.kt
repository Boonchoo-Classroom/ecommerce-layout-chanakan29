package scisrc.mobiledev.ecommercelayout.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import scisrc.mobiledev.ecommercelayout.R // ตรวจสอบ package name

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productNameTextView: TextView = itemView.findViewById(R.id.productName)
        val productPriceTextView: TextView = itemView.findViewById(R.id.productPrice)
        val productImageView: ImageView = itemView.findViewById(R.id.productImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.productNameTextView.text = product.name
        holder.productPriceTextView.text = product.price

        Glide.with(holder.productImageView.context)
            .load(product.imageURL)
            .into(holder.productImageView)
    }

    override fun getItemCount(): Int {
        return products.size
    }
}