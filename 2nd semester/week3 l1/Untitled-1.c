#include <stdio.h>
int main()
{
    int m, n, p, q;
    printf("Enter no of rows and columns for 1st matrix: ");
    scanf("%d %d", &m, &n);
    printf("Enter no of rows and columns for 2nd matrix: ");
    scanf("%d %d", &p, &q);
    if (n != p)
    {
        printf("Matrix Multiplication NOT possible");
        return 0;
    }
    int arr1[m][n], arr2[p][q], arr3[m][q];
    printf("Enter values for matrix 1: ");
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            scanf("%d", &arr1[i][j]);
        }
    }
    printf("Enter values for matrix 2: ");
    for (int i = 0; i < p; i++)
    {
        for (int j = 0; j < q; j++)
        {
            scanf("%d", &arr2[i][j]);
        }
    }
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < q; j++)
        {
            for (int k = 0; k < n; k++)
            {
                arr3[i][j] += arr1[i][k] * arr2[k][j];
            }
        }
    }
    printf("After matrix multiplication of matrix 1 and matrix 2 :-\n");
    for (int a = 0; a < m; a++)
    {
        for (int b = 0; b < q; b++)
        {
            printf("%d ", arr3[a][b]);
        }
        printf("\n");
    }
    return 0;
}
