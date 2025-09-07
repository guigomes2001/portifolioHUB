// JavaScript simplificado e corrigido para a seção de certificados
document.addEventListener('DOMContentLoaded', function() {
    console.log('Script de certificados carregado');
    
    // Elementos do DOM
    const loadMoreButton = document.getElementById('loadMoreCertificates');
    const modal = document.getElementById('pdfModal');
    const pdfViewer = document.getElementById('pdfViewer');
    const closeModal = document.querySelector('.close-modal');
    
    // Verifica se os elementos existem
    if (!loadMoreButton) {
        console.error('Botão "Carregar Mais" não encontrado!');
        return;
    }
    
    // Seleciona todos os certificados ocultos
    const hiddenCertificates = document.querySelectorAll('.hidden-certificate');
    console.log(`${hiddenCertificates.length} certificados ocultos encontrados`);
    
    let currentIndex = 0;
    const certificatesPerLoad = 6;
    
    // Configuração do modal
    function setupModal() {
        // Abrir modal com o PDF
        document.querySelectorAll('.view-certificate').forEach(button => {
            button.addEventListener('click', function() {
                const pdfUrl = this.getAttribute('data-pdf');
                console.log('Abrindo PDF:', pdfUrl);
                pdfViewer.src = pdfUrl;
                modal.style.display = 'block';
                document.body.style.overflow = 'hidden';
            });
        });
        
        // Fechar modal
        closeModal.addEventListener('click', function() {
            modal.style.display = 'none';
            pdfViewer.src = '';
            document.body.style.overflow = 'auto';
        });
        
        // Fechar modal clicando fora dele
        window.addEventListener('click', function(event) {
            if (event.target === modal) {
                modal.style.display = 'none';
                pdfViewer.src = '';
                document.body.style.overflow = 'auto';
            }
        });
    }
    
    // Função para carregar mais certificados
    function loadMoreCertificates() {
        console.log('Botão clicado. Carregando mais certificados...');
        
        // Calcula quantos certificados podemos mostrar
        const remainingCertificates = hiddenCertificates.length - currentIndex;
        const certificatesToShow = Math.min(certificatesPerLoad, remainingCertificates);
        
        console.log(`Mostrando ${certificatesToShow} de ${remainingCertificates} certificados restantes`);
        
        // Mostra os próximos certificados
        for (let i = 0; i < certificatesToShow; i++) {
            if (hiddenCertificates[currentIndex]) {
                hiddenCertificates[currentIndex].classList.remove('hidden-certificate');
                console.log(`Certificado ${currentIndex + 1} exibido`);
                currentIndex++;
            }
        }
        
        // Esconde o botão se não houver mais certificados
        if (currentIndex >= hiddenCertificates.length) {
            loadMoreButton.style.display = 'none';
            console.log('Todos os certificados foram carregados. Ocultando botão.');
        }
        
        // Reconfigura os eventos do modal para os novos certificados
        setupModal();
    }
    
    // Configurar o botão "Carregar Mais"
    if (hiddenCertificates.length > 0) {
        loadMoreButton.addEventListener('click', loadMoreCertificates);
        console.log('Botão "Carregar Mais" configurado com sucesso');
    } else {
        loadMoreButton.style.display = 'none';
        console.log('Nenhum certificado oculto encontrado. Ocultando botão.');
    }
    
    // Configuração inicial do modal
    setupModal();
});