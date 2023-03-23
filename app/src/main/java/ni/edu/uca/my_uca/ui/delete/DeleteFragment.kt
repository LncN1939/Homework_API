package ni.edu.uca.my_uca.ui.delete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import ni.edu.uca.my_uca.databinding.FragmentAddBinding
import ni.edu.uca.my_uca.databinding.FragmentDeleteBinding
import ni.edu.uca.my_uca.ui.add.AddViewModel

class DeleteFragment : Fragment() {
    private var _binding: FragmentDeleteBinding? = null
    private val binding get() = _binding!!

    var txtSee: EditText?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeleteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       binding.button.setOnClickListener(){
            Toast.makeText(getActivity(),"HOLAAAAA",Toast.LENGTH_LONG).show()
        }

        /**binding.btnId.setOnClickListener(){
            val url="http://192.168.100.12:8080/Api-Android/damo/delete_data.php"
            val queue=Volley.newRequestQueue(getActivity())
            var resultadoPost = object : StringRequest(Request.Method.POST, url,
            Response.Listener { response ->
                Toast.makeText(getActivity(),"El usuario se ha borrado de manera exitosa",Toast.LENGTH_LONG).show()
            }, Response.ErrorListener { error ->
                Toast.makeText(getActivity(),"Error $error",Toast.LENGTH_LONG).show()
                }){
                override fun getParams(): MutableMap<String, String>? {
                    val parametros = HashMap<String,String>()
                    parametros.put("id",txtSee?.text.toString())
                    return parametros
                }
            }
            queue.add(resultadoPost)
        }**/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}