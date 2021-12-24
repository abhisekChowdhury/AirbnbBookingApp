package com.example.bikeapplication.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalexam_300307958.Entities.ListingItem
import com.example.finalexam_300307958.R
import com.example.finalexam_300307958.databinding.ListItemBinding

class Adapter(private val listings: List<ListingItem>,
              private val listener: ListItemListener
): RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val binding = ListItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val airbnb = listings[position]
        with(holder.binding) {
            tvUrl.text = airbnb.listing_url
            tvName.text = airbnb.name
            tvSummary.text = airbnb.summary
            tvSpace.text = airbnb.space
            tvDescription.text = airbnb.description
            tvPropertytype.text = airbnb.property_type
            tvMinnights.text = airbnb.minimum_nights
            tvMaxnights.text = airbnb.maximum_nights
            tvAccommodates.text = airbnb.accommodates.toString()
            tvBedrooms.text = airbnb.bedrooms.toString()
            tvBeds.text = airbnb.beds.toString()
            tvBathrooms.text = airbnb.bathrooms.toString()


//            vendorNameTextView.text = "Bike Brand: " + bike.Brand
//            costPerHourTextView.text = "Bike Price: $" + bike.Price
//
//            if(bike.Brand.equals("GIANT",ignoreCase = true)){
//                bikeListImageView.setImageResource(R.drawable.bike1)
//            }
//            else if(bike.Brand.equals("LIV",ignoreCase = true)){
//                bikeListImageView.setImageResource(R.drawable.bike2)
//            }
//            else if(bike.Brand.equals("HERO",ignoreCase = true)){
//                bikeListImageView.setImageResource(R.drawable.bike3)
//            }
//            else if(bike.Brand.equals("HERCULES",ignoreCase = true)){
//                bikeListImageView.setImageResource(R.drawable.bike4)
//            }
//            else if(bike.Brand.equals("TREK",ignoreCase = true)){
//                bikeListImageView.setImageResource(R.drawable.bike5)
//            }
//            else{
//                bikeListImageView.setImageResource(R.drawable.bello_logos_transparent)
//            }
//            root.setOnClickListener{
//                listener.onItemClick(bike._id.`$oid`)
//            }
        }
    }

    override fun getItemCount(): Int {
        return listings.size
    }

    interface ListItemListener {
        //fun editNote(noteId: Int)
        //fun onItemClick(noteId: String)
    }

}