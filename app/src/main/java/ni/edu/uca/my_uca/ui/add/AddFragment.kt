package ni.edu.uca.my_uca.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    var txtNombre: EditText?=null
    var txtApellido: EditText?=null
    var txtCarrera: EditText?=null
    var txtAnio: EditText?=null
    var tvId: EditText?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtNombre = binding.txtNombre
        txtApellido = binding.txtApellido
        txtCarrera = binding.txtCarrera
        txtAnio = binding.txtAnio

        binding.button2.setOnClickListener(){
                val url="http://192.168.100.12:8080/Api-Android/damo/delete_data.php"
                val queue=Volley.newRequestQueue(getActivity())
                var resultadoPost = object : StringRequest(Request.Method.POST, url,
                    Response.Listener<String> { response ->
                        Toast.makeText(getActivity(),"El usuario se ha borrado de manera exitosa",Toast.LENGTH_LONG).show()
                    },
                    Response.ErrorListener { error ->
                        Toast.makeText(getActivity(),"Error $error",Toast.LENGTH_LONG).show()
                    }){
                    override fun getParams(): MutableMap<String, String> {
                        val parametro = HashMap<String,String>()
                        parametro.put("id",txtAnio?.text.toString())
                        return parametro
                    }
                }
                queue.add(resultadoPost)
            }

        binding.btnSubmit.setOnClickListener(){
            val url="http://192.168.100.12:8080/Api-Android/damo/add_data.php"
            val queue= Volley.newRequestQueue(getActivity())
            var resultadoPost = object : StringRequest(Request.Method.POST,url,
                Response.Listener<String> { response ->
                    Toast.makeText(getActivity(),"Usuario ha sido insertado existosamente", Toast.LENGTH_LONG).show()
                }, Response.ErrorListener { error ->
                    Toast.makeText(getActivity(),"Error: $error", Toast.LENGTH_LONG).show()
                }){
                override fun getParams(): MutableMap<String, String>    {
                    val parametros=HashMap<String, String>()
                    parametros.put("nombre", txtNombre?.text.toString())
                    parametros.put("apellido", txtApellido?.text.toString())
                    parametros.put("carrera", txtCarrera?.text.toString())
                    parametros.put("año", txtAnio?.text.toString())
                    return parametros
                }
            }
            queue.add(resultadoPost)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}