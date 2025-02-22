package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import scisrc.mobiledev.ecommercelayout.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadUserProfile()
    }

    private fun loadUserProfile() {
        // TODO: ดึงข้อมูลโปรไฟล์ผู้ใช้จากแหล่งข้อมูลของคุณ
        val userName = "UserName: สมชาย ใจดี"
        val userEmail = "Email: somchai.jaidee@example.com"
        val userAddress = "Address: 123/4 ถ.สุขุมวิท แขวงคลองเตย เขตคลองเตย กรุงเทพฯ 10110"

        binding.nameTextView.text = userName
        binding.emailTextView.text = userEmail
        binding.addressTextView.text = userAddress

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}