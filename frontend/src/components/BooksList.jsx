import React from 'react'
import { gql, useQuery } from '@apollo/client'

const BOOKS_QUERY = gql`
  query Books {
    books {
      id
      name
      pageCount
      author { id firstName lastName }
    }
  }
`

export default function BooksList(){
  const { data, loading, error } = useQuery(BOOKS_QUERY)
  if(loading) return <div>Loading...</div>
  if(error) return <div>Error: {error.message}</div>
  return (
    <ul>
      {data.books.map(b => (
        <li key={b.id}>
          <strong>{b.name}</strong> — {b.pageCount} pages — {b.author.firstName} {b.author.lastName}
        </li>
      ))}
    </ul>
  )
}

