package br.com.codeowner.season1.core

import kotlinx.serialization.Serializable
import java.util.UUID
import kotlin.random.Random

@Serializable
data class Trip(
    val id: String,
    val origin: CardinalPoint,
    val destination: CardinalPoint,
    val distance: Double,
    val duration: Double
) {
    constructor(origin: CardinalPoint, destination: CardinalPoint) : this(
        id = UUID.randomUUID().toString(),
        origin = origin,
        destination = destination,
        distance = Random.nextDouble(0.0, 1000.0),
        duration = Random.nextDouble(0.0, 1000.0)
    )

    @Serializable
    data class CardinalPoint(
        val latitude: Double,
        val longitude: Double
    )
}
