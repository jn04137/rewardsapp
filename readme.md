# About this Example

- Application runs on port 8080.
- H2 Database is available and preloaded with data via Spring Boot and data.sql file.
  - Data can be reviewed at the /h2-console portal once application is running
- Ready to query for json on application start.
- Utilizes Java 21.
- If using intellij, may need to set up lombok in order to run test atomically.
- Import ordering and no use of wildcards are to my team's standard at my current employer.

# Data
There are 3 customerIds available to try the endpoints on.
1. Jonathan Nguyen (1) 
2. Keanu Reeves (2)
3. Shia Lebeouf (3)

In the runtime section, the outputs are demonstrated for running the endpoints PathVariables specifically for 
customerId 1 (Jonathan Nguyen).

More data can be added via the data.sql file if more examples are desired.

# Runtime

## Endpoints

### /transactions
```json
{
    "1": {
    "customerId": 1,
    "customerName": "Jonathan Nguyen",
    "totalRewards": 7640
},
    "2": {
    "customerId": 5,
    "customerName": "Keanu Reeves",
    "totalRewards": 10
},
    "3": {
    "customerId": 6,
    "customerName": "Shia Lebeouf",
    "totalRewards": 0
    }
}
```

### /transactions/{customerId}

/transactions/1

```json
[
  {
    "id": 1,
    "transactionDate": "2026-02-16",
    "products": [
      {
        "id": 1,
        "productName": "RTX 3080",
        "productPrice": 699.99
      },
      {
        "id": 1,
        "productName": "RTX 3080",
        "productPrice": 699.99
      },
      {
        "id": 1,
        "productName": "RTX 3080",
        "productPrice": 699.99
      }
    ],
    "customer": {
      "id": 1,
      "customerName": "Jonathan Nguyen",
      "transactions": []
    },
    "reward": 4050,
    "total": 2099.97
  },
  {
    "id": 2,
    "transactionDate": "2026-01-19",
    "products": [
      {
        "id": 10,
        "productName": "Corsair 500D",
        "productPrice": 59.99
      },
      {
        "id": 3,
        "productName": "RTX 3060",
        "productPrice": 269.99
      },
      {
        "id": 6,
        "productName": "Intel Core i5 12900K",
        "productPrice": 259.99
      },
      {
        "id": 9,
        "productName": "Crucial DDR5 16GB RAM",
        "productPrice": 129.99
      }
    ],
    "customer": {
      "id": 1,
      "customerName": "Jonathan Nguyen",
      "transactions": []
    },
    "reward": 1290,
    "total": 719.96
  },
  {
    "id": 3,
    "transactionDate": "2025-12-01",
    "products": [
      {
        "id": 11,
        "productName": "NZXT 510",
        "productPrice": 159.99
      },
      {
        "id": 2,
        "productName": "RTX 3070",
        "productPrice": 399.99
      },
      {
        "id": 5,
        "productName": "Intel Core i7 13900K",
        "productPrice": 359.99
      },
      {
        "id": 8,
        "productName": "Crucial DDR5 32GB RAM",
        "productPrice": 159.99
      }
    ],
    "customer": {
      "id": 1,
      "customerName": "Jonathan Nguyen",
      "transactions": []
    },
    "reward": 2010,
    "total": 1079.96
  },
  {
    "id": 4,
    "transactionDate": "2025-11-01",
    "products": [
      {
        "id": 1,
        "productName": "RTX 3080",
        "productPrice": 699.99
      },
      {
        "id": 4,
        "productName": "Intel Core i9 14900K",
        "productPrice": 499.99
      },
      {
        "id": 7,
        "productName": "Crucial DDR5 64GB RAM",
        "productPrice": 259.99
      },
      {
        "id": 1,
        "productName": "RTX 3080",
        "productPrice": 699.99
      },
      {
        "id": 4,
        "productName": "Intel Core i9 14900K",
        "productPrice": 499.99
      },
      {
        "id": 7,
        "productName": "Crucial DDR5 64GB RAM",
        "productPrice": 259.99
      }
    ],
    "customer": {
      "id": 1,
      "customerName": "Jonathan Nguyen",
      "transactions": []
    },
    "reward": 5690,
    "total": 2919.94
  },
  {
    "id": 7,
    "transactionDate": "2026-01-25",
    "products": [
      {
        "id": 11,
        "productName": "NZXT 510",
        "productPrice": 159.99
      },
      {
        "id": 12,
        "productName": "Noctua Fan",
        "productPrice": 14.99
      },
      {
        "id": 12,
        "productName": "Noctua Fan",
        "productPrice": 14.99
      },
      {
        "id": 12,
        "productName": "Noctua Fan",
        "productPrice": 14.99
      },
      {
        "id": 12,
        "productName": "Noctua Fan",
        "productPrice": 14.99
      }
    ],
    "customer": {
      "id": 1,
      "customerName": "Jonathan Nguyen",
      "transactions": []
    },
    "reward": 290,
    "total": 219.95
  }
]
```

### /rewards
```json
{
    "1": {
        "customerId": 1,
        "customerName": "Jonathan Nguyen",
        "totalRewards": 7640
    },
    "2": {
        "customerId": 5,
        "customerName": "Keanu Reeves",
        "totalRewards": 10
    },
    "3": {
        "customerId": 6,
        "customerName": "Shia Lebeouf",
        "totalRewards": 0
    }
}
```

### /rewards/{customerId}

/rewards/1

```json
{
    "rewards": 7640,
    "rewardsByMonthMap": {
        "2025-12": {
            "rewardsOverMonth": 2010,
            "transactions": [
                {
                    "id": 3,
                    "transactionDate": "2025-12-01",
                    "products": [
                        {
                            "id": 11,
                            "productName": "NZXT 510",
                            "productPrice": 159.99
                        },
                        {
                            "id": 2,
                            "productName": "RTX 3070",
                            "productPrice": 399.99
                        },
                        {
                            "id": 5,
                            "productName": "Intel Core i7 13900K",
                            "productPrice": 359.99
                        },
                        {
                            "id": 8,
                            "productName": "Crucial DDR5 32GB RAM",
                            "productPrice": 159.99
                        }
                    ],
                    "customer": {
                        "id": 1,
                        "customerName": "Jonathan Nguyen",
                        "transactions": []
                    },
                    "reward": 2010,
                    "total": 1079.96
                }
            ]
        },
        "2026-02": {
            "rewardsOverMonth": 4050,
            "transactions": [
                {
                    "id": 1,
                    "transactionDate": "2026-02-16",
                    "products": [
                        {
                            "id": 1,
                            "productName": "RTX 3080",
                            "productPrice": 699.99
                        },
                        {
                            "id": 1,
                            "productName": "RTX 3080",
                            "productPrice": 699.99
                        },
                        {
                            "id": 1,
                            "productName": "RTX 3080",
                            "productPrice": 699.99
                        }
                    ],
                    "customer": {
                        "id": 1,
                        "customerName": "Jonathan Nguyen",
                        "transactions": []
                    },
                    "reward": 4050,
                    "total": 2099.97
                }
            ]
        },
        "2026-01": {
            "rewardsOverMonth": 1580,
            "transactions": [
                {
                    "id": 2,
                    "transactionDate": "2026-01-19",
                    "products": [
                        {
                            "id": 10,
                            "productName": "Corsair 500D",
                            "productPrice": 59.99
                        },
                        {
                            "id": 3,
                            "productName": "RTX 3060",
                            "productPrice": 269.99
                        },
                        {
                            "id": 6,
                            "productName": "Intel Core i5 12900K",
                            "productPrice": 259.99
                        },
                        {
                            "id": 9,
                            "productName": "Crucial DDR5 16GB RAM",
                            "productPrice": 129.99
                        }
                    ],
                    "customer": {
                        "id": 1,
                        "customerName": "Jonathan Nguyen",
                        "transactions": []
                    },
                    "reward": 1290,
                    "total": 719.96
                },
                {
                    "id": 7,
                    "transactionDate": "2026-01-25",
                    "products": [
                        {
                            "id": 11,
                            "productName": "NZXT 510",
                            "productPrice": 159.99
                        },
                        {
                            "id": 12,
                            "productName": "Noctua Fan",
                            "productPrice": 14.99
                        },
                        {
                            "id": 12,
                            "productName": "Noctua Fan",
                            "productPrice": 14.99
                        },
                        {
                            "id": 12,
                            "productName": "Noctua Fan",
                            "productPrice": 14.99
                        },
                        {
                            "id": 12,
                            "productName": "Noctua Fan",
                            "productPrice": 14.99
                        }
                    ],
                    "customer": {
                        "id": 1,
                        "customerName": "Jonathan Nguyen",
                        "transactions": []
                    },
                    "reward": 290,
                    "total": 219.95
                }
            ]
        }
    }
}
```
