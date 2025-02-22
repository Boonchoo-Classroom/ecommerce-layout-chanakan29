package scisrc.mobiledev.ecommercelayout.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import scisrc.mobiledev.ecommercelayout.databinding.ItemProductCategoryBinding

class CategoryAdapter(
    private val categoryList: List<ProductCategory>,
    private val onCategoryClick: (ProductCategory) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemProductCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding, onCategoryClick)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    override fun getItemCount() = categoryList.size

    class CategoryViewHolder(
        private val binding: ItemProductCategoryBinding,
        private val onCategoryClick: (ProductCategory) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: ProductCategory) {
            binding.categoryName.text = category.name
            Glide.with(binding.root.context).load(category.imageURL).into(binding.categoryImage)
            itemView.setOnClickListener { onCategoryClick(category) }
        }
    }
}