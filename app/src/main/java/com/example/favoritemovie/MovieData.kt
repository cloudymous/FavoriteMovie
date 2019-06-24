package com.example.favoritemovie

object MovieData {

    var data = arrayOf(
        arrayOf(
            "Toy Story 4",
            "7.2",
            "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \"Forky\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy.",
            "https://image.tmdb.org/t/p/w500/crvO4xm2gs5W0joyKmJf1l1ThZV.jpg"
        ),
        arrayOf(
            "Dark Phoenix",
            "6.3",
            "The X-Men face their most formidable and powerful foe when one of their own, Jean Grey, starts to spiral out of control. During a rescue mission in outer space, Jean is nearly killed when she's hit by a mysterious cosmic force. Once she returns home, this force not only makes her infinitely more powerful, but far more unstable. The X-Men must now band together to save her soul and battle aliens that want to use Grey's new abilities to rule the galaxy.",
            "https://image.tmdb.org/t/p/w500/kZv92eTc0Gg3mKxqjjDAM73z9cy.jpg"
        )

    )

    val listData: ArrayList<Movie>
        get() {
            val list = ArrayList<Movie>()
            for (aData in data) {
                val movie = Movie()
                movie.movieName = aData[0]
                movie.movieRating = aData[1]
                movie.movieOverview = aData[2]
                movie.moviePoster = aData[3]

                list.add(movie)
            }

            return list
        }
}