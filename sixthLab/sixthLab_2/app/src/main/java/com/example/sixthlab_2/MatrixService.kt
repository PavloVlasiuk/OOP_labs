package com.example.sixthlab_2

import kotlin.random.Random

class MatrixService {
    fun generateMatrix(n: Int, min: Int, max: Int): Array<IntArray> {
        val matrix: Array<IntArray> = Array(n) { IntArray(n) }

        for (i: Int in 0 until n) {
            for (j: Int in 0 until n) {
                matrix[i][j] = Random.nextInt(min, max + 1)
            }
        }

        return matrix
    }

    fun calculateDeterminant(matrix: Array<IntArray>): Int {
        val n = matrix.size

        return when (n) {
            1 -> matrix[0][0]
            2 -> matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]
            else -> {
                var determinant = 0
                for (column in 0 until n) {
                    val sign = if (column % 2 == 0) 1 else -1
                    val minorMatrix = createMinorMatrix(matrix, 0, column)
                    determinant += sign * matrix[0][column] * calculateDeterminant(minorMatrix)
                }
                determinant
            }
        }
    }

    private fun createMinorMatrix(
        matrix: Array<IntArray>,
        rowToRemove: Int,
        colToRemove: Int
    ): Array<IntArray> {
        return matrix.filterIndexed { rowIndex, _ -> rowIndex != rowToRemove }
            .map { it.filterIndexed { colIndex, _ -> colIndex != colToRemove }.toIntArray() }
            .toTypedArray()
    }
}
