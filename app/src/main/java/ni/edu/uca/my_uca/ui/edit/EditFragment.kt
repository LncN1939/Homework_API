package ni.edu.uca.my_uca.ui.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ni.edu.uca.my_uca.databinding.FragmentAddBinding
import ni.edu.uca.my_uca.databinding.FragmentEditBinding
import ni.edu.uca.my_uca.ui.add.AddViewModel

class EditFragment : Fragment(){

    private var _binding: FragmentEditBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val addViewModel =
            ViewModelProvider(this).get(EditViewModel::class.java)

        _binding = FragmentEditBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textEdit
        addViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}