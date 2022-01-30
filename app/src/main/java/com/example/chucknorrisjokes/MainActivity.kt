package com.example.chucknorrisjokes

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder
import org.json.JSONException

import org.json.JSONObject

import org.json.JSONArray




const val BASE_URL="http://api.icndb.com/jokes/"

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener{
            getMyData()
        }

    }
private fun getMyData(){
        val joke = arrayOf<String>("The Chuck Norris military unit was not used in the game Civilization 4, because a single Chuck Norris could defeat the entire combined nations of the world in one turn.",
            "Chuck Norris is the only human being to display the Heisenberg uncertainty principle - you can never know both exactly where and how quickly he will roundhouse-kick you in the face.",
            "Chuck Norris originally appeared in the &quot;Street Fighter II&quot; video game, but was removed by Beta Testers because every button caused him to do a roundhouse kick. When asked about this glitch, Norris replied &quot;That's no glitch.&quot;",
            "Scientists have estimated that the energy given off during the Big Bang is roughly equal to 1CNRhK (Chuck Norris Roundhouse Kick).",
            "Chuck Norris knows the last digit of pi.",
            "When Chuck Norris throws exceptions, it's across the room.",
            "All arrays Chuck Norris declares are of infinite size, because Chuck Norris knows no bounds.",
            "Chuck Norris doesn't have disk latency because the hard drive knows to hurry the hell up.",
            "Chuck Norris writes code that optimizes itself.",
            "Chuck Norris can't test for equality because he has no equal.",
            "Chuck Norris doesn't need garbage collection because he doesn't call .Dispose(), he calls .DropKick().",
            "Chuck Norris's first program was kill -9.",
            "Chuck Norris burst the dot com bubble.",
            "All browsers support the hex definitions #chuck and #norris for the colors black and blue.",
            "MySpace actually isn't your space, it's Chuck's (he just lets you use it).",
            "Chuck Norris can write infinite recursion functions and have them return.",
            "Chuck Norris can solve the Towers of Hanoi in one move.",
            "The only pattern Chuck Norris knows is God Object.",
            "Chuck Norris finished World of Warcraft.",
            "Project managers never ask Chuck Norris for estimations... ever.",
            "Chuck Norris doesn't use web standards as the web will conform to him.",
            "It works on my machine, always holds true for Chuck Norris.",
            "Chuck Norris doesn't do Burn Down charts, he does Smack Down charts.",
            "Chuck Norris can delete the Recycling Bin.",
            "Chuck Norris's beard can type 140 wpm.",
            "Chuck Norris can unit test entire applications with a single assert.",
            "Chuck Norris doesn't bug hunt as that signifies a probability of failure, he goes bug killing.",
            "Chuck Norris's keyboard doesn't have a Ctrl key because nothing controls Chuck Norris.",
            "When Chuck Norris is web surfing websites get the message &quot;Warning: Internet Explorer has deemed this user to be malicious or dangerous. Proceed?&quot;.",
            "Chuck Norris can overflow your stack just by looking at it.",
            "To Chuck Norris, everything contains a vulnerability.",
            "Chuck Norris doesn't need sudo, he just types &quot;Chuck Norris&quot; before his commands.",
            "Chuck Norris doesn't need a debugger, he just stares down the bug until the code confesses.",
            "Chuck Norris can access private methods.",
            "Chuck Norris can instantiate an abstract class.",
            "Chuck Norris does not need to know about class factory pattern. He can instantiate interfaces.",
            "The class object inherits from Chuck Norris",
            "For Chuck Norris, NP-Hard = O(1).",
            "Chuck Norris' Internet connection is faster upstream than downstream because even data has more incentive to run from him than to him.",
            "Chuck Norris solved the Travelling Salesman problem in O(1) time. Here's the pseudo-code: Break salesman into N pieces. Kick each piece to a different city.",
            "No statement can catch the ChuckNorrisException.",
            "Chuck Norris doesn't pair program.",
            "Chuck Norris can write multi-threaded applications with a single thread.",
            "Chuck Norris doesn't need to use AJAX because pages are too afraid to postback anyways.",
            "Chuck Norris doesn't use reflection, reflection asks politely for his help.",
            "There is no Esc key on Chuck Norris' keyboard, because no one escapes Chuck Norris.",
            "Chuck Norris can binary search unsorted data.",
            "Chuck Norris breaks RSA 128-bit encrypted codes in milliseconds.",
            "Chuck Norris doesn't needs try-catch, exceptions are too afraid to raise.",
            "Chuck Norris went out of an infinite loop.",
            "If Chuck Norris writes code with bugs, the bugs fix themselves.",
            "Chuck Norris hosting is 101% uptime guaranteed.",
            "Chuck Norris's keyboard has the Any key.",
            "Chuck Norris can access the DB from the UI.",
            "Chuck Norris' programs never exit, they terminate.",
            "Chuck Norris insists on strongly-typed programming languages.",
            "Chuck Norris protocol design method has no status, requests or responses, only commands.",
            "Chuck Norris programs occupy 150% of CPU, even when they are not executing.",
            "Chuck Norris can spawn threads that complete before they are started.",
            "Chuck Norris programs do not accept input.",
            "Chuck Norris can install iTunes without installing Quicktime.",
            "Chuck Norris doesn't need an OS.",
            "Chuck Norris's OSI network model has only one layer - Physical.",
            "Chuck Norris can compile syntax errors.",
            "Every SQL statement that Chuck Norris codes has an implicit &quot;COMMIT&quot; in its end.",
            "Chuck Norris does not need to type-cast. The Chuck-Norris Compiler (CNC) sees through things. All way down. Always.",
            "Chuck Norris does not code in cycles, he codes in strikes.",
            "Chuck Norris compresses his files by doing a flying round house kick to the hard drive.",
            "Chuck Norris solved the halting problem.",
            "With Chuck Norris P = NP. There's no nondeterminism with Chuck Norris decisions.",
            "Chuck Norris can retrieve anything from /dev/null.",
            "No one has ever pair-programmed with Chuck Norris and lived to tell about it.",
            "No one has ever spoken during review of Chuck Norris' code and lived to tell about it.",
            "Chuck Norris doesn't use GUI, he prefers COMMAND line.",
            "Chuck Norris doesn't use Oracle, he is the Oracle.",
            "Chuck Norris can dereference NULL.",
            "A diff between your code and Chuck Norris's is infinite.",
            "The Chuck Norris Eclipse plugin made alien contact.",
            "Chuck Norris is the ultimate mutex, all threads fear him.",
            "Chuck Norris uses canvas in IE.",
            "Don't worry about tests, Chuck Norris's test cases cover your code too.",
            "Each hair in Chuck Norris's beard contributes to make the world's largest DDOS.",
            "Chuck Norris's log statements are always at the FATAL level.",
            "Chuck Norris's database has only one table, 'Kick', which he DROPs frequently.",
            "When Chuck Norris break the build, you can't fix it, because there is not a single line of code left.",
            "Chuck Norris types with one finger. He points it at the keyboard and the keyboard does the rest.",
            "Chuck Norris's programs can pass the Turing Test by staring at the interrogator.",
            "If you try to kill -9 Chuck Norris's programs, it backfires.",
            "Chuck Norris does infinite loops in 4 seconds.",
            "Product Owners never ask Chuck Norris for more features. They ask for mercy.",
            "Product Owners never argue with Chuck Norris after he demonstrates the DropKick feature.",
            "Chuck Norris can over-write a locked variable.",
            "Chuck Norris knows the value of NULL, and he can sort by it too.",
            "Chuck Norris can install a 64 bit OS on 32 bit machines.",
            "Chuck Norris can write to an output stream.",
            "Chuck Norris can read from an input stream.",
            "Chuck Norris never has to build his program to machine code. Machines have learnt to interpret Chuck Norris code.",
            "Chuck Norris' unit tests don't run. They die.",
            "Chuck Norris causes the Windows Blue Screen of Death.",
            "Chuck Norris can download emails with his pick-up.",
            "Chuck Norris can make a class that is both abstract and final.",
            "Chuck Norris could use anything in java.util.* to kill you, including the javadocs.",
            "Code runs faster when Chuck Norris watches it.",
            "Only Chuck Norris shuts down websites without due process, not SOPA or PIPA.",
            "Chuck Norris doesn't need a keyboard he tells the computer to write something and it does."
            )
    val randomNumber = (0..103).random()
    val txtId = findViewById<TextView>(R.id.textJoke)
    txtId.text=joke[randomNumber]


}}