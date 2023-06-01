package com.example.amphibians.adapter
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.amphibians.model.Amphibian
import com.example.amphibians.ui.AmphibianLIstFragmentDirections
import com.example.roomdb.databinding.RowLayoutBinding


class AnimalAdapter(): RecyclerView.Adapter<AnimalAdapter.myViewholder>() {

    var list = emptyList<Amphibian>()

    class myViewholder(private var binding: RowLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Amphibian) {
           binding.animalText.text = item.name

            binding.rowLayout.setOnClickListener {
                val action = AmphibianLIstFragmentDirections.actionAmphibianLIstFragmentToDetailsFragment(item)
                val NavController = Navigation.findNavController(binding.root)
                NavController.navigate(action)
            }
        }

        companion object {
            fun from(parent: ViewGroup): myViewholder {
                var LayoutInflater = android.view.LayoutInflater.from(parent.context)
                var binding = RowLayoutBinding.inflate(LayoutInflater, parent, false)
                return myViewholder(binding)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewholder {

        return myViewholder.from(parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: myViewholder, position: Int) {
        var item = list[position]
         holder.bind(item)


    }

    fun setData(amphibian: List<Amphibian>) {
        list = amphibian
        notifyDataSetChanged()
    }


}