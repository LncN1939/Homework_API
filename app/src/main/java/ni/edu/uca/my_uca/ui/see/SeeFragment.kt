package ni.edu.uca.my_uca.ui.see

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import ni.edu.uca.my_uca.databinding.FragmentSeeBinding

class SeeFragment : Fragment() {

    private var _binding: FragmentSeeBinding? = null
    private val binding get() = _binding!!
    var userList = arrayListOf<User>()
    val apiLink = "http://192.168.100.12:8080/Api-Android/damo/read_data.php"
    var recycleView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSeeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycleView = binding.recyclerview

        val reqQueue: RequestQueue = Volley.newRequestQueue(getActivity())
        val request = JsonObjectRequest(Request.Method.GET,apiLink,null, { res ->
            val jsonArray = res.getJSONArray("data")
            Log.d("Volley Sample",jsonArray.toString())

            for (i in 0 until jsonArray.length()){
                val jsonObj = jsonArray.getJSONObject(i)
                Log.d("Volley Sample",jsonObj.toString())
                val user = User(
                    jsonObj.getString("id"),
                    jsonObj.getString("nombre"),
                    jsonObj.getString("apellido"),
                    jsonObj.getString("carrera"),
                    jsonObj.getString("año")
                )
                Log.d("PedroVaAsuCasa", userList.toString())
                userList.add(user)
            }
            Log.d("PedroVaAsuCasa", userList.toString())
            println(userList.toString())

            recycleView?.layoutManager = LinearLayoutManager(getActivity())
            recycleView?.adapter = UserAdapter(userList)

        },{err ->
            Log.d("Volley fail", err.message.toString())
        })

        reqQueue.add(request)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}