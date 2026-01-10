import { useEffect, useState } from 'react';
import { listarProdutos } from '../../service/produtoService';
import type { Produto } from '../../types/Produto';

export default function Home() {
  const [produtos, setProdutos] = useState<Produto[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    listarProdutos()
      .then((data) => setProdutos(data))
      .catch((error) => console.error(error))
      .finally(() => setLoading(false));
  }, []);

  if (loading) {
    return <p>Carregando produtos...</p>;
  }

  return (
    <div>
      <h1>Produtos</h1>

      {produtos.length === 0 && <p>Nenhum produto cadastrado</p>}

      {produtos.map((produto) => (
        <div key={produto.id}>
          <h2>{produto.nome}</h2>
          <p>{produto.descricao}</p>
          <strong>R$ {produto.preco}</strong>
        </div>
      ))}
    </div>
  );
}
