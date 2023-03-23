package ni.edu.uca.my_uca.ui.see

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.my_uca.R
import ni.edu.uca.my_uca.databinding.UserItemBinding

class UserAdapter (private val userList: ArrayList<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(private val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root){
        fun load(item: User){
            binding.idtv.text = item.id
            binding.nombretv.text = item.name
            binding.apellidotv.text = item.secondName
            binding.carreratv.text = item.carear
            binding.aniotv.text = item.year
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val userItem = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(userItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.load(this.userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}