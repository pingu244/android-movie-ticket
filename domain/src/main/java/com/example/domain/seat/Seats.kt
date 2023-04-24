package com.example.domain.seat

object Seats {

    fun makeSeats(): Map<SeatPosition, SeatState> {
        val position = makeSeatPosition()
        val result = mutableMapOf<SeatPosition, SeatState>()
        position.map {
            val rank = when (it.row) {
                SeatRow.A, SeatRow.B -> SeatRank.B
                SeatRow.C, SeatRow.D -> SeatRank.S
                SeatRow.E -> SeatRank.A
            }
            result.put(it, SeatState(false, rank))
        }
        return result
    }

    private fun makeSeatPosition(): List<SeatPosition> {
        return SeatRow.values().flatMap { seatRow ->
            (1..4).map {
                SeatPosition(seatRow, it)
            }
        }
    }
}
