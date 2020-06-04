package com.example.movieapp.adapter

import android.content.res.Resources
import android.graphics.Movie
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.models.MovieListResponse

class MovieListItemDecorator() : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val adapter = parent.adapter
        if (adapter is MovieListRVAdapter) {
            if (position >= 0) {
                val item = adapter.getItem(position)
                setItemOffset(outRect, view, parent, state, item, position)
            } else {
                // viewholder has been removed
                setItemOffsetOnRemoval(outRect, view, parent, state, position)
            }
        }
    }

    private fun setItemOffsetOnRemoval(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State, position: Int
    ) {
        val item = view.tag
        if (item != null) {
            setItemOffset(outRect, view, parent, state, item, position)
        }
    }

    private fun setItemOffset(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
        item: Any,
        position: Int
    ) {
        when(item){
            is MovieListResponse -> {
                if(position == 0){
                    outRect.top = (20 * Resources.getSystem().getDisplayMetrics().density).toInt()
                }
                outRect.bottom = (30 * Resources.getSystem().getDisplayMetrics().density).toInt()
                outRect.left = (15 * Resources.getSystem().getDisplayMetrics().density).toInt()
                outRect.right = (15 * Resources.getSystem().getDisplayMetrics().density).toInt()
            }
        }
    }
}