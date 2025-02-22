package scisrc.mobiledev.ecommercelayout.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import scisrc.mobiledev.ecommercelayout.databinding.ItemProductCategoryBinding

// CategoryAdapter ฉบับแก้ไข - แก้ไข Error Unresolved reference: onCategoryClick
class CategoryAdapter(
    private val categoryList: List<ProductCategory>,
    onCategoryClick: (ProductCategory) -> Unit // เปลี่ยนจาก private val เป็น val ธรรมดา (หรือไม่มี Modifier)
) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    // เพิ่ม property ระดับ Class เพื่อเก็บ onCategoryClick (private เพื่อให้ Encapsulation)
    private val categoryClickListener: (ProductCategory) -> Unit = onCategoryClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemProductCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding, categoryClickListener) // ส่ง categoryClickListener เข้า ViewHolder Constructor
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    override fun getItemCount() = categoryList.size

    class CategoryViewHolder(
        private val binding: ItemProductCategoryBinding,
        private val onCategoryClick: (ProductCategory) -> Unit // รับ Callback Function ผ่าน Constructor ของ ViewHolder
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: ProductCategory) {
            binding.categoryName.text = category.name
            Glide.with(binding.root.context)
                .load(category.imageURL)
                .into(binding.categoryImage)

            itemView.setOnClickListener {
                // เรียกใช้งาน Callback Function ผ่าน Property ที่รับมาจาก ViewHolder Constructor
                onCategoryClick(category) // บรรทัดนี้จะไม่เกิด Error Unresolved reference แล้ว
            }
        }
    }
}