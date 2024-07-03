package ru.itis.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import ru.itis.homework2.databinding.FragmentMusicBinding


class MusicFragment : Fragment(R.layout.fragment_music) {
    private var binding: FragmentMusicBinding? = null

    private var adapter: TrackAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMusicBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter(){
        adapter = TrackAdapter(TrackRepository.tracks, Glide.with(this), click = {

            id -> var bundle = Bundle()
            bundle.putInt("ID",id)
            findNavController().navigate(resId = R.id.action_notificationsFragment_to_trackFragment,args = bundle)

        })
        binding?.run {
            rvMusic.adapter = adapter
            rvMusic.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}