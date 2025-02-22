package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.databinding.FragmentCategoryProductListBinding

class CategoryProductListFragment : Fragment() {

    private var _binding: FragmentCategoryProductListBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_CATEGORY_ID = "category_id"
        // ลบฟังก์ชัน newInstance()
    }

    private val categoryId: String by lazy {
        arguments?.getString(ARG_CATEGORY_ID) ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupProductRecyclerView()
    }

    private fun setupProductRecyclerView() {
        val productList = getProductListForCategory(categoryId)
        val adapter = ProductAdapter(productList)
        binding.productListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.productListRecyclerView.adapter = adapter
    }

    private fun getProductListForCategory(categoryId: String): List<Product> {
        return when (categoryId) {
            "อุปกรณ์เครื่องเขียน" -> listOf(
                Product("สินค้า 1", "10 บาท", "https://images.unsplash.com/photo-1523275335684-37898b6baf30?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cHJvZHVjdHxlbnwwfHwwfHx8MA%3D%3D"),
                Product("สินค้า 2", "25 บาท", "https://media.istockphoto.com/id/173015527/photo/a-single-red-book-on-a-white-surface.jpg?s=612x612&w=0&k=20&c=AeKmdZvg2_bRY2Yct7odWhZXav8CgDtLMc_5_pjSItY="),
                Product("สินค้า 3", "30 บาท", "https://m.media-amazon.com/images/I/51vOMolqGsL._AC_UF1000,1000_QL80_.jpg"),
                Product("สินค้า 4", "50 บาท", "https://media.istockphoto.com/id/1354020635/photo/white-t-shirt-mockup-front-used-as-design-template-tee-shirt-blank-isolated-on-white.jpg?s=612x612&w=0&k=20&c=Dk9vgHFqFrwXQNfnEq8_0WN6IjQ35UysBNaMgUh4IjA=")
            )
            "อุปกรณ์กีฬา" -> listOf(
                Product("ลูกบอล", "300 บาท", "https://via.placeholder.com/150/D3D3D3/000000?text=Promo+3"),
                Product("ไม้แบด", "450 บาท", "https://via.placeholder.com/150/D3D3D3/000000?text=Promo+3")
            )
            "Gadget" -> listOf(
                Product("หูฟัง", "990 บาท", "https://via.placeholder.com/150/D3D3D3/000000?text=Promo+3"),
                Product("เมาส์", "590 บาท", "https://via.placeholder.com/150/D3D3D3/000000?text=Promo+3")
            )
            "เสื้อผ้า" -> listOf(
                Product("เสื้อยืด", "250 บาท", "https://via.placeholder.com/150/D3D3D3/000000?text=Promo+3"),
                Product("กางเกงยีนส์", "790 บาท", "https://via.placeholder.com/150/D3D3D3/000000?text=Promo+3")
            )
            else -> {
                emptyList()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}