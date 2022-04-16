package com.bosta.bostaapp.features.fragments.photos.domain

import com.bosta.bostaapp.core.mapper.BaseListMapper
import com.bosta.bostaapp.features.fragments.photos.data.PhotoItem
import com.bosta.bostaapp.features.fragments.photos.data.PhotosResponseItem

object PhotosMapper : BaseListMapper<List<PhotosResponseItem>, PhotosResponseItem, PhotoItem> {
    override fun mapListData(res: List<PhotosResponseItem>): List<PhotoItem> = res.map {
        mapItem(it)
    }

    override fun mapItem(res: PhotosResponseItem?): PhotoItem =
        PhotoItem(
            photoId = res?.id ?: -1,
            albumId = res?.id ?: -1,
            photoTitle = res?.title ?: "",
            url = res?.url ?: "", // In Case of error will load Bosta Logo instead of it
            thumbnailUrl = res?.thumbnailUrl ?: "",
        )
}