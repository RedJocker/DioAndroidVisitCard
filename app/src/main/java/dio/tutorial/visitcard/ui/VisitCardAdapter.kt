package dio.tutorial.visitcard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dio.tutorial.visitcard.data.VisitCard
import dio.tutorial.visitcard.databinding.ItemVisitCardBinding

class VisitCardAdapter : ListAdapter<VisitCard, VisitCardAdapter.ViewHolder>(DiffCallback()){


    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemVisitCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
            private val binding: ItemVisitCardBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: VisitCard) {
            binding.tvName.text = item.name
            binding.tvPhone.text = item.phone
            binding.tvMail.text = item.mail
            binding.tvCompany.text = item.company
            binding.mcvContent.setBackgroundColor(Color.parseColor(item.color))
            binding.mcvContent.setOnClickListener { listenerShare(it)}
        }
    }


}

class DiffCallback: DiffUtil.ItemCallback<VisitCard>() {
    override fun areItemsTheSame(oldItem: VisitCard, newItem: VisitCard): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: VisitCard, newItem: VisitCard): Boolean {
       return oldItem == newItem
    }

}