package  com.umikhotimatus.acer.sportdbapps.model

import retrofit.http.GET
import retrofit.http.Query
import rx.Observable

interface ApiService {

    @GET("eventsnextleague.php")
    fun getNextMatch(@Query("id") id: String): Observable<ItemsSport>

    @GET("lookup_all_teams.php")
    fun getTeamByLigaId(@Query("id") id: String): Observable<ItemsSport>
}