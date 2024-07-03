package ru.itis.homework2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.homework2.databinding.ItemMusicBinding

class TrackAdapter(
    private val list: List<Track>,
    private val glide: RequestManager,
    private val click : (Int) -> Unit
) : RecyclerView.Adapter<TrackHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): TrackHolder = TrackHolder(glide,
            ItemMusicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),click
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TrackHolder, position: Int) {
        holder.onBind(list[position])
    }
}