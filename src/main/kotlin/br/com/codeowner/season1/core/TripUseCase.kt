package br.com.codeowner.season1.core

import br.com.codeowner.season1.core.Trip.CardinalPoint

class TripUseCase {
    fun getTrip(): Trip {
        return Trip(
            CardinalPoint(0.0, 0.0),
            CardinalPoint(0.0, 0.0)
        )
    }
}
