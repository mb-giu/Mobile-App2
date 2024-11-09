import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.heroeslist.DetailsActivity
import com.example.heroeslist.R
import org.w3c.dom.Text

class HeroesAdapter(
    private val heroes: List<Hero>,
    private val context: Context,
    private val click: (hero: Hero) -> Unit
) : Adapter<HeroesAdapter.HeroesViewHolder>() {

    inner class HeroesViewHolder(itemView: View) : ViewHolder(itemView) {
        val heroName = itemView.findViewById<TextView>(R.id.heroName)
        val heroCompany = itemView.findViewById<TextView>(R.id.heroCompany)
        val heroImage = itemView.findViewById<ImageView>(R.id.heroImage)
        val heroPower = itemView.findViewById<TextView>(R.id.heroPower)

        fun bind(hero: Hero) {
            heroName.text = hero.heroName
            heroCompany.text = hero.heroCompany
            heroImage.setImageResource(hero.heroImage)
            heroPower.text = hero.heroPower
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailsActivity::class.java)
                itemView.context.startActivity(intent)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return HeroesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return heroes.size
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        val hero = heroes[position]
        holder.bind(hero)
    }
}