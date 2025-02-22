package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager // Import GridLayoutManager
import scisrc.mobiledev.ecommercelayout.databinding.FragmentProductListBinding
import android.widget.Toast

class ProductListFragment : Fragment() {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCategoryRecyclerView() // เรียก Function setupCategoryRecyclerView() ตรงนี้!
    }

    private fun setupCategoryRecyclerView() {
        val categoryList = getCategoryList()
        val adapter = CategoryAdapter(categoryList) { category ->
            // TODO: ทำอะไรบางอย่างเมื่อหมวดหมู่ถูกคลิก เช่น นำทางไปยังหน้าแสดงสินค้าในหมวดหมู่
            // ตัวอย่าง: แสดง Toast Message
            Toast.makeText(requireContext(), "Clicked on category: ${category.name}", Toast.LENGTH_SHORT).show()
            // หรือ นำทางไปยัง Fragment/Activity อื่นๆ
        }
        binding.categoryRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.categoryRecyclerView.adapter = adapter
    }

    private fun getCategoryList(): List<ProductCategory> { // Function สำหรับสร้าง List<ProductCategory> (ข้อมูล Mock)
        return listOf(
            ProductCategory("อุปกรณ์เครื่องเขียน", "https://t3.ftcdn.net/jpg/02/48/42/64/360_F_248426448_NVKLywWqArG2ADUxDq6QprtIzsF82dMF.jpg"),
            ProductCategory("อุปกรณ์กีฬา", "https://t3.ftcdn.net/jpg/02/48/42/64/360_F_248426448_NVKLywWqArG2ADUxDq6QprtIzsF82dMF.jpg"),
            ProductCategory("Gadget", "https://t3.ftcdn.net/jpg/02/48/42/64/360_F_248426448_NVKLywWqArG2ADUxDq6QprtIzsF82dMF.jpg"),
            ProductCategory("เสื้อผ้า", "https://t3.ftcdn.net/jpg/02/48/42/64/360_F_248426448_NVKLywWqArG2ADUxDq6QprtIzsF82dMF.jpg")
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}