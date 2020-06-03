package com.blitzware.brazukacarcleanuser.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blitzware.brazukacarcleanuser.R
import com.blitzware.brazukacarcleanuser.network.response.CompaniesHomeResponse
import com.blitzware.brazukacarcleanuser.util.ImageUtils
import kotlinx.android.synthetic.main.item_adapter_companies.view.*

class ComapaniesHomeAdapter(
    val context: Context,
    private var companies: List<CompaniesHomeResponse>
) : RecyclerView.Adapter<ComapaniesHomeAdapter.ComaniesHomeViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComaniesHomeViewHolder {
        return ComaniesHomeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_adapter_companies, parent, false))
    }

    override fun getItemCount(): Int {
        return companies.size
    }

    override fun onBindViewHolder(
        holder: ComapaniesHomeAdapter.ComaniesHomeViewHolder,
        position: Int
    ) {
        holder.bindView(companies[position])
    }

    class ComaniesHomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNameCompany = itemView.tv_nome_company
        val tvAddress = itemView.tv_streetname
        val ivCompanyLogo = itemView.iv_company
        fun bindView(company : CompaniesHomeResponse) {
            ivCompanyLogo.setImageBitmap(company.logo?.let { ImageUtils.convert(it) })
            tvNameCompany.text = company.fantasyName
            tvAddress.text = company.address?.streetName ?: "" + company.address?.number ?: ""
        }
    }
}
