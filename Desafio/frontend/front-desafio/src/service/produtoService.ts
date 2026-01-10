import { api } from './api';
import { type Produto } from '../types/Produto';

export async function listarProdutos(): Promise<Produto[]> {
  const response = await api.get<Produto[]>('/produtos');
  return response.data;
}

export async function buscarProdutoPorId(id: string): Promise<Produto> {
  const response = await api.get<Produto>(`/produtos/${id}`);
  return response.data;
}

export async function criarProduto(
  produto: Omit<Produto, 'id'>
): Promise<Produto> {
  const response = await api.post<Produto>('/produtos', produto);
  return response.data;
}
