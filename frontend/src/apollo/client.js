import { ApolloClient, InMemoryCache, createHttpLink } from '@apollo/client'
import { setContext } from '@apollo/client/link/context'

const httpLink = createHttpLink({ uri: 'http://localhost:8080/graphql' })

const authLink = setContext((_, { headers }) => {
  const token = localStorage.getItem('token')
  return { headers: { ...headers, ...(token ? { Authorization: `Bearer ${token}` } : {}) } }
})

export const apolloClient = new ApolloClient({ link: authLink.concat(httpLink), cache: new InMemoryCache() })

